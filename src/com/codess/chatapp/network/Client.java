package com.codess.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.codess.chatapp.utils.ConfigReader;

public class Client {
    private Socket socket;
    private OutputStream out;
    private InputStream in;
    private ClientWorker worker;
    private JTextArea textArea;

    public Client(JTextArea textArea) throws UnknownHostException, IOException {
        this.textArea = textArea;

        int PORT = Integer.parseInt(ConfigReader.getValue("PORT"));
        String serverIP = ConfigReader.getValue("SERVER_IP");

        // Connect to server
        this.socket = new Socket(serverIP, PORT);
        this.out = socket.getOutputStream();
        this.in = socket.getInputStream();

        readMessages();  
    }
    
//  /*System.out.println("Client Comes");
//  System.out.println("Enter the Message Send to the Server.....");
//  Scanner scanner= new Scanner(System.in);
//  String message = scanner.nextLine();
//  OutputStream out = socket.getOutputStream(); // Write Bytes on Network
//  out.write(message.getBytes());
//  System.out.println("Message Send to the Server");
//  scanner.close();
//  out.close();
//  socket.close(); */
   

    public void sendMessage(String message) throws IOException {
        if (message != null && !message.trim().isEmpty()) {
            message += "\n";
            out.write(message.getBytes("UTF-8"));  // use UTF-8 encoding
            out.flush();
        }
    }

    private void readMessages() {
        worker = new ClientWorker(in, textArea);
        worker.start();
    }
}
