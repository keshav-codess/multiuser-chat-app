package com.codess.chatapp.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.codess.chatapp.utils.ConfigReader;

public class Server {

    private ServerSocket serverSocket;
    public final List<ServerWorker> workers = new ArrayList<>();

    public Server() throws IOException {
        int port = Integer.parseInt(ConfigReader.getValue("PORT"));
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port + ". Waiting for clients...");
        handleClientRequests();
    }

    private void handleClientRequests() throws IOException {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                ServerWorker worker = new ServerWorker(clientSocket, this);
                workers.add(worker);
                worker.start();
            } catch (IOException ex) {
                System.err.println("Error accepting client connection: " + ex.getMessage());
            }
        }
    }

    public List<ServerWorker> getWorkers() {
        return workers;
    }

    // For Single Client
    /*
    public Server() throws IOException {
        int PORT = Integer.parseInt(ConfigReader.getValue("PORT"));
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server Started And Waiting For Client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client Connected");
        InputStream in = socket.getInputStream(); // read bytes from socket
        byte arr[] = in.readAllBytes();
        String str = new String(arr); // bytes convert into String
        System.out.println("Message From The Client : " + str);
        in.close();
        socket.close();
    }
    */
    
    public static void main(String[] args) {
        try {
            new Server();
        } catch (IOException ex) {
            System.err.println("Server failed to start: " + ex.getMessage());
        }
    }
}
