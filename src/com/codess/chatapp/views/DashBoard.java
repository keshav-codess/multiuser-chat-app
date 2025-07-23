package com.codess.chatapp.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DashBoard extends JFrame {
    private static final long serialVersionUID = 1L;

    public DashBoard(String message) {
        setTitle("ChatApp Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupMenuBar();
        setupContent(message);
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(255, 222, 173));
        menuBar.setBorderPainted(false);

        JMenu chatMenu = new JMenu("Chat");
        chatMenu.setForeground(Color.WHITE);
        chatMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JMenuItem startChat = new JMenuItem("Start New Chat");
        startChat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        startChat.setBackground(new Color(0, 250, 154));
        startChat.addActionListener((ActionEvent e) -> {
            try {
                new ClientChatScreen();
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Unable to start chat: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        chatMenu.add(startChat);
        menuBar.add(chatMenu);
        setJMenuBar(menuBar);
    }

    private void setupContent(String message) {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(30, 30, 30, 30));
        contentPane.setBackground(new Color(245, 245, 245));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Top Panel (Welcome)
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(new Color(245, 245, 245));
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel(message, SwingConstants.CENTER);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(60, 63, 65));
        welcomeLabel.setBorder(new EmptyBorder(10, 0, 20, 0));

        welcomePanel.add(welcomeLabel);

        // Center Image
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        try {
            ImageIcon icon = new ImageIcon(DashBoard.class.getResource("/images/fd7fed48-9910-4ccc-8894-c2d9543e0ccc (1) (2).png"));
            Image image = icon.getImage().getScaledInstance(500, 350, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
        } catch (Exception ex) {
            imageLabel.setText("Image not found");
            imageLabel.setFont(new Font("Arial", Font.ITALIC, 16));
            imageLabel.setForeground(Color.RED);
        }

        welcomePanel.add(imageLabel);

        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        timePanel.setBackground(new Color(245, 245, 245));
        JLabel timeLabel = new JLabel(getCurrentDateTime());
        timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        timeLabel.setForeground(new Color(100, 100, 100));
        timePanel.add(timeLabel);

        contentPane.add(welcomePanel, BorderLayout.CENTER);
        contentPane.add(timePanel, BorderLayout.SOUTH);
    }

    private String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy | hh:mm a");
        return formatter.format(new Date());
    }
}
