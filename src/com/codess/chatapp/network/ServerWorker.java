package com.codess.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread {
    private Socket clientSocket;
    private InputStream in;
    private OutputStream out;
    private Server server;

    public ServerWorker(Socket clientSocket, Server server) throws IOException {
        this.server = server;
        this.clientSocket = clientSocket;
        this.in = clientSocket.getInputStream();    // For reading data from client
        this.out = clientSocket.getOutputStream();  // For sending data to client
        System.out.println("New Client Joined");
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;

        try {
            while ((line = br.readLine()) != null) {
                System.out.println("Line Read: " + line);

                if (line.equalsIgnoreCase("quit")) {
                    break;
                }

                broadcast(line + "\n");
            }
        } 
        catch (IOException e) {
            System.out.println("Client disconnected unexpectedly");
        }
        finally {
            cleanup();
        }
    }

    private void broadcast(String message) throws IOException {
        for (ServerWorker worker : server.workers) {
            try {
                worker.out.write(message.getBytes());
            }
            catch (IOException e) {
                System.out.println("Error sending message to a client.");
                e.printStackTrace();
            }
        }
    }

    private void cleanup() {
        try {
            System.out.println("Cleaning up client connection...");
            server.workers.remove(this); 

            if (in != null) {
            	in.close();
            }
            if (out != null){
            	out.close();
            }
            if (clientSocket != null && !clientSocket.isClosed()) {
            	clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
