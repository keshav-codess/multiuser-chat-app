package com.codess.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

//data read
public class ClientWorker extends Thread {
    private InputStream in;
    private JTextArea textArea;

    public ClientWorker(InputStream in, JTextArea textArea) {
        this.in = in;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = br.readLine()) != null) {
                final String message = line;
                SwingUtilities.invokeLater(() -> {
                    textArea.append(message + "\n");
                });
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
