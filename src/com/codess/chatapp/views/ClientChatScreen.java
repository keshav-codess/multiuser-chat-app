package com.codess.chatapp.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.codess.chatapp.network.Client;
import com.codess.chatapp.utils.UserInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

public class ClientChatScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    private Client client;

    public static void main(String[] args) throws UnknownHostException {
        UserInfo.USER_NAME = JOptionPane.showInputDialog("Enter your name:");
        if (UserInfo.USER_NAME != null && !UserInfo.USER_NAME.trim().isEmpty()) {
            try {
                new ClientChatScreen();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to connect to server.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username is required.");
        }
    }

    private void sendIt() {
        String message = textField.getText().trim();
        if (!message.isEmpty()) {
            try {
                client.sendMessage(UserInfo.USER_NAME + ": " + message);
                textField.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ClientChatScreen() throws UnknownHostException, IOException {
        setTitle("ChatApp - " + UserInfo.USER_NAME);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 879, 493);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 845, 360);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField.setBounds(10, 394, 629, 52);
        contentPane.add(textField);
        textField.setColumns(10);

        textField.addActionListener(e -> sendIt());

        JButton sendButton = new JButton("Send");
        sendButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        sendButton.addActionListener(e -> sendIt());
        sendButton.setBounds(670, 397, 161, 45);
        contentPane.add(sendButton);

        client = new Client(textArea); 

        setVisible(true);
    }
}
