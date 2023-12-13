package com.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class gradeWindow {

    public static JFrame frame = new JFrame();
    public static JPanel panel = new JPanel();
    
    public gradeWindow() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(Color.lightGray);
        Logging.log("Started Grade Panel");

        ImageIcon img = new ImageIcon("res\\Untitled.png");
        frame.setIconImage(img.getImage());
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Home Access Center API");   
        frame.setSize(400, 450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setResizable(false);
        Logging.log("Started Grade Frame");
        loadGrades(Main.gradeLabelList);
    }

    private static void loadGrades(ArrayList<JLabel> arr) {
        Main.getGrades();
        for(int x = 0; x <= Main.gradeLabelList.size(); x++) {
            panel.add(Main.gradeLabelList.get(x));
        }
    }
}
