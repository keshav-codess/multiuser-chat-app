package com.codess.chatapp.views;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.*;

import com.codess.chatapp.dao.UserDAO;
import com.codess.chatapp.dto.UserDTO;
import com.codess.chatapp.utils.UserInfo;

public class UserScreen extends JFrame {
    private JTextField useridtxt;
    private JPasswordField passwordtxt;
    UserDAO userDAO = new UserDAO();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new UserScreen());
    }

    private void doLogin() {
        String userid = useridtxt.getText();
        char[] password = passwordtxt.getPassword();

        if (userid.isEmpty() || password.length == 0) {
            JOptionPane.showMessageDialog(this, "User ID and Password cannot be empty");
            return;
        }

        UserDTO userDTO = new UserDTO(userid, password);
        try {
            if (userDAO.isLogin(userDTO)) {
                UserInfo.USER_NAME = userid;
                JOptionPane.showMessageDialog(this, "Welcome " + userid + " to chat app.");
                dispose();
                DashBoard dashBoard = new DashBoard("Welcome " + userid + " to chat app.");
                dashBoard.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid User ID or Password");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Arrays.fill(password, '0'); 
        }
    }

    private void Register() {
        String userid = useridtxt.getText();
        char[] password = passwordtxt.getPassword();

        if (userid.isEmpty() || password.length == 0) {
            JOptionPane.showMessageDialog(this, "User ID and Password cannot be empty");
            return;
        }

        UserDTO userDTO = new UserDTO(userid, password);
        try {
            int result = userDAO.add(userDTO);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Registered Successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Registration Failed");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database Issue...");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Some Generic Issue");
            ex.printStackTrace();
        } finally {
            Arrays.fill(password, '0'); 
        }
    }

    public UserScreen() {
        setResizable(false);
        setTitle("LOGIN");
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("LOGIN");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 37));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(332, 47, 134, 49);
        getContentPane().add(lblNewLabel);

        JLabel useridlbl = new JLabel("User ID");
        useridlbl.setHorizontalAlignment(SwingConstants.LEFT);
        useridlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        useridlbl.setBounds(226, 130, 90, 24);
        getContentPane().add(useridlbl);

        useridtxt = new JTextField();
        useridtxt.setBounds(412, 130, 250, 34);
        useridtxt.setColumns(10);
        useridtxt.setToolTipText("Enter your User ID");
        getContentPane().add(useridtxt);

        JLabel pwdlbl = new JLabel("Password");
        pwdlbl.setHorizontalAlignment(SwingConstants.CENTER);
        pwdlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pwdlbl.setBounds(226, 190, 90, 24);
        getContentPane().add(pwdlbl);

        passwordtxt = new JPasswordField();
        passwordtxt.setBounds(412, 190, 250, 34);
        passwordtxt.setToolTipText("Enter your Password");
        getContentPane().add(passwordtxt);

        JButton loginbt = new JButton("Login");
        loginbt.setFont(new Font("Tahoma", Font.PLAIN, 17));
        loginbt.setBounds(300, 293, 98, 34);
        loginbt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doLogin();
            }
        });
        getContentPane().add(loginbt);

        JButton registerbt = new JButton("Register");
        registerbt.setFont(new Font("Tahoma", Font.PLAIN, 17));
        registerbt.setBounds(456, 293, 98, 34);
        registerbt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Register();
            }
        });
        getContentPane().add(registerbt);

        getRootPane().setDefaultButton(loginbt); 

        setSize(833, 441);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
