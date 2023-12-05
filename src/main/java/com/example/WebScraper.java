package com.example;

import java.time.Duration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebScraper {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JTextField userTextField = new JTextField();
    private JPasswordField passTextField = new JPasswordField();
    private JLabel gradeLabel1 = new JLabel();
    private JLabel gradeLabel2 = new JLabel();
    private JLabel gradeLabel3 = new JLabel();
    private JLabel gradeLabel4 = new JLabel();
    private JLabel gradeLabel5 = new JLabel();
    private JLabel gradeLabel6 = new JLabel();
    private JLabel gradeLabel7 = new JLabel();

    JButton submitButton = new JButton( new AbstractAction("Login") {
        @Override
        public void actionPerformed( ActionEvent e ) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        ChromeDriver driver = new ChromeDriver(options);
        Logging.log("Driver Initialized");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://grades.tomballisd.net/HomeAccess/Account/LogOn?ReturnUrl=%2fhomeaccess%2f");
        Logging.log("Website Reached");

        double startTime = System.currentTimeMillis();
        driver.findElement(By.id("LogOnDetails_UserName")).sendKeys(userTextField.getText());
        driver.findElement(By.id("LogOnDetails_Password")).sendKeys(passTextField.getText());
        driver.findElement(By.id("login")).click();
        try {
            driver.switchTo().frame(driver.findElement(By.id("sg-legacy-iframe")));
            driver.switchTo().defaultContent();
            driver.findElement(By.id("hac-Classes")).click();
            driver.switchTo().frame(driver.findElement(By.id("sg-legacy-iframe")));
            Logging.log("User Logged In");
            try {
                String i = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"plnMain_pnlFullPage\"]/div[4]/div[1]/a"))).getText());
                if(driver.findElement(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_0")).isDisplayed()) {
                    gradeLabel1.setText(i + " - " + wait.until(ExpectedConditions.presenceOfElementLocated(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_0"))).getText());
                }else{
                    gradeLabel1.setText(i + " - N/A");
                }
                
                //System.out.println(gradeLabel1.getText().substring(8));
                //rawGrade(gradeLabel1.getText().substring(8));
                //System.out.println(gradeLabel1.getText().substring(8));
                //gradeLabel1.setForeground(Color.getGradeColor(Double grade)(Double.parseDouble(gradeLabel1.getText().substring(0, 0))));
                if(rawGrade(gradeLabel1.getText().substring(8)) >= 90) {
                    gradeLabel1.setForeground(Color.green);
                }else if(rawGrade(gradeLabel1.getText().substring(8)) >= 80) {
                    gradeLabel1.setForeground(Color.yellow);
                }else if(rawGrade(gradeLabel1.getText().substring(8)) >= 70) {
                    gradeLabel1.setForeground(Color.orange);
                }else{
                    gradeLabel1.setForeground(Color.red);
                }

                i = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"plnMain_pnlFullPage\"]/div[5]/div[1]/a"))).getText());
                if(driver.findElement(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_1")).isDisplayed()) {
                    gradeLabel2.setText(i + " - " + wait.until(ExpectedConditions.presenceOfElementLocated(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_1"))).getText());
                }else{
                    gradeLabel2.setText(i + " - N/A");
                } 
                if(rawGrade(gradeLabel2.getText().substring(8)) >= 90) {
                    gradeLabel2.setForeground(Color.green);
                }else if(rawGrade(gradeLabel2.getText().substring(8)) >= 80) {
                    gradeLabel2.setForeground(Color.yellow);
                }else if(rawGrade(gradeLabel2.getText().substring(8)) >= 70) {
                    gradeLabel2.setForeground(Color.orange);
                }else{
                    gradeLabel2.setForeground(Color.red);
                }

                i = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"plnMain_pnlFullPage\"]/div[6]/div[1]/a"))).getText());
                if(driver.findElement(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_1")).isDisplayed()) {
                    gradeLabel3.setText(i + " - " + wait.until(ExpectedConditions.presenceOfElementLocated(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_2"))).getText());
                }else{
                    gradeLabel3.setText(i + " - N/A");
                }
                if(rawGrade(gradeLabel3.getText().substring(8)) >= 90) {
                    gradeLabel3.setForeground(Color.green);
                }else if(rawGrade(gradeLabel3.getText().substring(8)) >= 80) {
                    gradeLabel3.setForeground(Color.yellow);
                }else if(rawGrade(gradeLabel3.getText().substring(8)) >= 70) {
                    gradeLabel3.setForeground(Color.orange);
                }else{
                    gradeLabel3.setForeground(Color.red);
                }

                i = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"plnMain_pnlFullPage\"]/div[7]/div[1]/a"))).getText());
                if(driver.findElement(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_3")).isDisplayed()) {
                    gradeLabel4.setText(i + " - " + wait.until(ExpectedConditions.presenceOfElementLocated(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_3"))).getText());
                }else{
                    gradeLabel4.setText(i + " - N/A");
                }
                if(rawGrade(gradeLabel4.getText().substring(8)) >= 90) {
                    gradeLabel4.setForeground(Color.green);
                }else if(rawGrade(gradeLabel4.getText().substring(8)) >= 80) {
                    gradeLabel4.setForeground(Color.yellow);
                }else if(rawGrade(gradeLabel4.getText().substring(8)) >= 70) {
                    gradeLabel4.setForeground(Color.orange);
                }else{
                    gradeLabel4.setForeground(Color.red);
                }

                i = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"plnMain_pnlFullPage\"]/div[8]/div[1]/a"))).getText());
                if(driver.findElement(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_4")).isDisplayed()) {
                    gradeLabel5.setText(i + " - " + wait.until(ExpectedConditions.presenceOfElementLocated(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_4"))).getText());
                }else{
                    gradeLabel5.setText(i + " - N/A");
                }
                if(rawGrade(gradeLabel5.getText().substring(8)) >= 90) {
                    gradeLabel5.setForeground(Color.green);
                }else if(rawGrade(gradeLabel5.getText().substring(8)) >= 80) {
                    gradeLabel5.setForeground(Color.yellow);
                }else if(rawGrade(gradeLabel5.getText().substring(8)) >= 70) {
                    gradeLabel5.setForeground(Color.orange);
                }else{
                    gradeLabel5.setForeground(Color.red);
                }

                i = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"plnMain_pnlFullPage\"]/div[9]/div[1]/a"))).getText());
                if(driver.findElement(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_5")).isDisplayed()) {
                    gradeLabel6.setText(i + " - " + wait.until(ExpectedConditions.presenceOfElementLocated(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_5"))).getText());
                }else{
                    gradeLabel6.setText(i + " - N/A");
                }
                if(rawGrade(gradeLabel6.getText().substring(8)) >= 90) {
                    gradeLabel6.setForeground(Color.green);
                }else if(rawGrade(gradeLabel6.getText().substring(8)) >= 80) {
                    gradeLabel6.setForeground(Color.yellow);
                }else if(rawGrade(gradeLabel6.getText().substring(8)) >= 70) {
                    gradeLabel6.setForeground(Color.orange);
                }else{
                    gradeLabel6.setForeground(Color.red);
                }

                i = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"plnMain_pnlFullPage\"]/div[10]/div[1]/a"))).getText());
                if(driver.findElement(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_6")).isDisplayed()) {
                    gradeLabel7.setText(i + " - " + wait.until(ExpectedConditions.presenceOfElementLocated(By.id("plnMain_rptAssigmnetsByCourse_lblHdrAverage_6"))).getText());
                }else{
                    gradeLabel7.setText(i + " - N/A");
                }
                if(rawGrade(gradeLabel7.getText().substring(8)) >= 90) {
                    gradeLabel7.setForeground(Color.green);
                }else if(rawGrade(gradeLabel7.getText().substring(8)) >= 80) {
                    gradeLabel7.setForeground(Color.yellow);
                }else if(rawGrade(gradeLabel7.getText().substring(8)) >= 70) {
                    gradeLabel7.setForeground(Color.orange);
                }else{
                    gradeLabel7.setForeground(Color.red);
                }

                Logging.log("Fetched Averages in " + (System.currentTimeMillis() - startTime) + " milliseconds.");
                
            } catch(Exception exception) {
                System.out.println("Could not find element specified");
                Logging.logError("Fetch Error; Could not Fetch Averages");
            };
        }catch(Exception exception){
            Logging.logError("Login Error; Invalid Credentials");
            gradeLabel1.setText("Incorrect login credentials");
        }
        driver.quit();
        Logging.log("Driver Stopped");
        }
    });

    public WebScraper() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(userTextField);
        userTextField.setBackground(Color.lightGray);
        panel.add(passTextField);
        passTextField.setBackground(Color.lightGray);
        panel.add(submitButton);
        submitButton.setBackground(Color.lightGray);
        panel.add(gradeLabel1);
        panel.add(gradeLabel2);
        panel.add(gradeLabel3);
        panel.add(gradeLabel4);
        panel.add(gradeLabel5);
        panel.add(gradeLabel6);
        panel.add(gradeLabel7);
        panel.setBackground(Color.lightGray);

        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Home Access Center API");   
        frame.setSize(400, 450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        Logging.log("Started GUI");
    }

    public static void main( String[] args ) throws InterruptedException {
        new WebScraper();
        Logging.log("Initialized GUI");
    }

    public static Double rawGrade(String x) {
        int i = x.indexOf("Average") + 8;
        int v = x.indexOf("%");

        try {
            return(Double.parseDouble(x.substring(i, v)));
        }catch(Exception e) {
            Logging.logError("Could not parse double grade");
        }
        return(Double.parseDouble(x));
    }
}