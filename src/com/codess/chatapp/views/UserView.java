package com.codess.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import javax.swing.*;

public class UserView extends JFrame {
    int counter;

    public UserView() {
        counter = 0;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Counter App");

        Container container = getContentPane();
        container.setLayout(null);

        JLabel welcome = new JLabel("Login");
        welcome.setFont(new Font("Arial", Font.BOLD, 40));
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setBounds(100, 70, 200, 70);
        container.add(welcome);

        JButton button = new JButton("Count");
        button.setBounds(100, 300, 200, 50);
        button.addActionListener(e -> {
            counter++;
            welcome.setText("Count : " + counter);
        });
        container.add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserView::new);  
    }
}
