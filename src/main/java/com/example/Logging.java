package com.example;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logging {
    public static void log(String Contents) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter("src\\main\\java\\com\\example\\log.txt", true));
            
            output.print("[" + getTime() + "] ");
            output.println(Contents);
            output.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }

    
    public static void logError(String Contents) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter("src\\main\\java\\com\\example\\log.txt", true));
            
            output.print("[" + getTime() + "] ");
            output.print("[ERROR] ");
            output.println(Contents);
            output.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }

    public static void logSuccess(String Contents) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter("src\\main\\java\\com\\example\\log.txt", true));
            
            output.print("[" + getTime() + "] ");
            output.print("[SUCCESS] ");
            output.println(Contents);
            output.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }

    public static String getTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        return dtf.format(now);
    }
}
