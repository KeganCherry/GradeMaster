package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class loginWindow {
    public static JFrame frame = new JFrame();
    public static JPanel panel = new JPanel();
    public static JTextField userTextField = new JTextField();
    public static JPasswordField passTextField = new JPasswordField();
    public static JLabel feedBack = new JLabel();

    JButton submitButton = new JButton( new AbstractAction("Login") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            Main.Login(userTextField.getText(), passTextField.getText());
            if (Main.loggedIn == true) {
                frame.dispose();
                new gradeWindow();
                feedBack.setText("Login Successful!");
            }else {
                feedBack.setText("Incorrect Credentials");
                Main.clearCreds();
            }

        }
    });

    public loginWindow() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(userTextField);
        userTextField.setBackground(Color.lightGray);
        panel.add(passTextField);
        passTextField.setBackground(Color.lightGray);
        panel.add(submitButton);
        submitButton.setBackground(Color.lightGray);
        panel.add(feedBack);
        panel.setBackground(Color.lightGray);
        Logging.log("Started Login Panel");

        ImageIcon img = new ImageIcon("res\\Untitled.png");
        frame.setIconImage(img.getImage());
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Home Access Center API");   
        frame.setSize(400, 215);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setResizable(false);
        Logging.log("Started Login Frame");  
    }
}
