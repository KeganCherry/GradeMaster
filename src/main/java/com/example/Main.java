package com.example;

import java.time.Duration;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

public class Main {
    public static ArrayList<JLabel> gradeLabelList = new ArrayList();
    public static boolean loggedIn = false;
    private static ChromeDriver driver;
    private static Wait<WebDriver> wait;

    public static void getGrades() {
        try {
            double startTime = System.currentTimeMillis();
            driver.switchTo().frame(driver.findElement(By.id("sg-legacy-iframe")));
            driver.switchTo().defaultContent();
            driver.findElement(By.id("hac-Classes")).click();
            driver.switchTo().frame(driver.findElement(By.id("sg-legacy-iframe")));
            Logging.logSuccess("User Logged In");
            try {
                for(int x = 0; driver.findElement(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_" + x)).isDisplayed(); x++) {
                    String i = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"plnMain_pnlFullPage\"]/div[" + (x + 4)+ "]/div[1]/a"))).getText());
                    if(driver.findElement(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_" + x)).isDisplayed()) {
                        gradeLabelList.add(new JLabel((i + " - " + wait.until(ExpectedConditions.presenceOfElementLocated(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_" + x))).getText())));
                    }else{
                        gradeLabelList.add(new JLabel((i + " - " + "N/A")));
                    }
                    if(rawGrade(gradeLabelList.get(x).getText().substring(8)) >= 90) {
                        gradeLabelList.get(x).setForeground(Color.green);
                    }else if(rawGrade(gradeLabelList.get(x).getText().substring(8)) >= 80) {
                        gradeLabelList.get(x).setForeground(Color.yellow);
                    }else if(rawGrade(gradeLabelList.get(x).getText().substring(8)) >= 70) {
                        gradeLabelList.get(x).setForeground(Color.orange);
                    }else{
                        gradeLabelList.get(x).setForeground(Color.red);
                    }
                }

                Logging.log("Fetched Averages in " + (System.currentTimeMillis() - startTime) + " milliseconds.");
                
            } catch(Exception exception) {
                System.out.println("Could not find element specified");
                Logging.logError("Fetch Error; Could not Fetch Averages");
            };
        }catch(Exception exception){
            Logging.logError("Login Error; User not logged in");
            //add way to tell user wrong password
        }
    }

    public static void Login(String userName, String passWord) {
        driver.findElement(By.id("LogOnDetails_UserName")).sendKeys(userName);
        driver.findElement(By.id("LogOnDetails_Password")).sendKeys(passWord);
        driver.findElement(By.id("login")).click();
        if(driver.findElement(By.id("sg-legacy-iframe")).isDisplayed()) {
            loggedIn = true;
        }else {
            loggedIn = false;
            Logging.logError("Login Error; Invalid Credentials");
        }

    }

    public static void clearCreds() {
        driver.findElement(By.id("LogOnDetails_UserName")).clear();;
        driver.findElement(By.id("LogOnDetails_Password")).clear();;
    }

    public static void InitializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu");
        driver = new ChromeDriver(options);

        Logging.logSuccess("Driver Initialized");

        driver.get("https://grades.tomballisd.net/HomeAccess/Account/LogOn?ReturnUrl=%2fhomeaccess%2f");
        Logging.logSuccess("Website Reached");
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public static void main( String[] args ) throws InterruptedException, IOException {
        new loginWindow();
        InitializeDriver();
    }

    public static Double rawGrade(String x) {
        try {
            return(Double.parseDouble(x.substring(x.indexOf("Average") + 8, x.indexOf("%"))));
        }catch(Exception e) {
            Logging.logError("Could not parse double grade");
        }
        return(Double.parseDouble(x));
    }
}