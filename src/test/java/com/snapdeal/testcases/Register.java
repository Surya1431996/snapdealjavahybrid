package com.snapdeal.testcases;

import com.snapdeal.base.Base;
import com.snapdeal.pages.LoginPage;
import com.snapdeal.pages.RegisterPage;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Register extends Base {
    public Register() throws IOException {
        super();
    }
    public WebDriver driver ;
    String mainWindow;
    @BeforeMethod
    public void setup() throws InterruptedException {
        driver =  initializeBrowser(prop.getProperty("browserName"));
        String actualTitle = "Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items";
        if (actualTitle.equals(driver.getTitle())) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        LoginPage lp = new LoginPage(driver);
        lp.clickAccountmenu();
        RegisterPage rp = new RegisterPage(driver);
        rp.register();
        driver.switchTo().frame(0);
    }

    @AfterMethod
    public void tearDown(){
        if (driver!=null) {
            driver.quit();
        }
    }
    @Test(priority = 1)
    public void verifyWithvalidCredentials() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teja05863@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("9560432707");
        rp.firstname("surya");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/2000";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if(monthDiff<0){
            isFuture=false;
            monthDiff = -1 * monthDiff;
        }
        for(int i=0; i<monthDiff;i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("Surya@123");
        rp.signin();
        String expe = String.valueOf(driver.findElement(By.xpath("//*[@id='login-register-modal']/div/div[10]/div[2]/p")).getText());
        System.out.println(expe);
        Assert.assertEquals(expe, "Please enter verification code (OTP) sent to:");
        Thread.sleep(4000);
    }
    @Test(priority = 2)
    public void invalidEmail() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teja05863@gmail");
        lp.continueBtn();
        String expe = String.valueOf(driver.findElement(By.xpath("//*[@id='userName-error']")).getText());
        System.out.println(expe);
        Assert.assertEquals(expe,"Please enter a valid mobile number or email");
        Thread.sleep(4000);
    }
    @Test(priority = 3)
    public void registerEmail() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("ast98490@gmail.com");
        lp.continueBtn();
        driver.findElement(By.id("loginUsingOtp")).click();
        Thread.sleep(15000);
        String pagetitle = driver.getTitle();
        System.out.println(pagetitle);
        Assert.assertEquals(pagetitle, "Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items");
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void invalidMobileno() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teju89011@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("956043270");
        rp.firstname("surya");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/1996";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if(monthDiff<0){
            isFuture=false;
            monthDiff = -1 * monthDiff;
        }
        for(int i=0; i<monthDiff;i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("Surya@123");
        rp.signin();
        String expe = String.valueOf(driver.findElement(By.xpath("//*[@id='j_number-error']")).getText());
        System.out.println(expe);
        Assert.assertEquals(expe,"Please enter a valid mobile number");
        Thread.sleep(2000);
    }
    @Test(priority = 5)
    public void registerMobileno() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teju89011@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("9560432706");
        rp.firstname("surya");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/1996";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if(monthDiff<0){
            isFuture=false;
            monthDiff = -1 * monthDiff;
        }
        for(int i=0; i<monthDiff;i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("Surya@123");
        rp.signin();
        String expe = String.valueOf(driver.findElement(By.xpath("//*[@id='signup-message']")).getText());
        System.out.println(expe);
        Assert.assertEquals(expe,"An account already exists with +91 9560432706");
        Thread.sleep(4000);
    }
    @Test(priority = 6)
    public void invalidName() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teju89011@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("9560432706");
        rp.firstname("s");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/1996";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if(monthDiff<0){
            isFuture=false;
            monthDiff = -1 * monthDiff;
        }
        for(int i=0; i<monthDiff;i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("Surya@123");
        rp.signin();
        String act = "Please enter a valid name";
        String expe = String.valueOf(driver.findElement(By.xpath("//*[@id='j_name-error']")).getText());
        System.out.println(expe);
        Assert.assertEquals(expe, "Please enter a valid name");
        Thread.sleep(2000);
    }
    @Test(priority = 7)
    public void invalidPassword() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teju89011@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("9560432706");
        rp.firstname("surya");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/1996";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if (monthDiff < 0) {
            isFuture = false;
            monthDiff = -1 * monthDiff;
        }
        for (int i = 0; i < monthDiff; i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("Su");
        rp.signin();
        String expe1 = String.valueOf(driver.findElement(By.xpath("//*[@id='j_password-error']")).getText());
        System.out.println(expe1);
        Assert.assertEquals(expe1, "Please enter a valid password");
        Thread.sleep(2000);
    }
    @Test(priority = 8)
    public void invalidPasswordandnameandvalidnumber() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teju89011@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("9560432706");
        rp.firstname("");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/1996";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if (monthDiff < 0) {
            isFuture = false;
            monthDiff = -1 * monthDiff;
        }
        for (int i = 0; i < monthDiff; i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("");
        rp.signin();
        String expe = String.valueOf(driver.findElement(By.xpath("//*[@id='j_name-error']")).getText());
        System.out.println(expe);
        Assert.assertEquals(expe, "Please enter your name");

        String expe1 = String.valueOf(driver.findElement(By.xpath("//*[@id='j_password-error']")).getText());
        System.out.println(expe1);
        Assert.assertEquals(expe1, "Please enter a password");
    }

    @Test(priority = 9)
    public void invalidPasswordandnoandvalidname() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teju89011@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("");
        rp.firstname("surya");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/1996";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if (monthDiff < 0) {
            isFuture = false;
            monthDiff = -1 * monthDiff;
        }
        for (int i = 0; i < monthDiff; i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("");
        rp.signin();
        String expe1 = String.valueOf(driver.findElement(By.xpath("//*[@id='j_number-error']")).getText());
        System.out.println(expe1);
        Assert.assertEquals(expe1, "Please enter a mobile number");

        String expe2 = String.valueOf(driver.findElement(By.xpath("//*[@id='j_password-error']")).getText());
        System.out.println(expe2);
        Assert.assertEquals(expe2, "Please enter a password");
    }
    @Test(priority = 10)
    public void invalidnameandnoandvalidpass() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teju89011@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("");
        rp.firstname("");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/1996";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if (monthDiff < 0) {
            isFuture = false;
            monthDiff = -1 * monthDiff;
        }
        for (int i = 0; i < monthDiff; i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("Surya@123");
        rp.signin();
        String expe1 = String.valueOf(driver.findElement(By.xpath("//*[@id='j_number-error']")).getText());
        System.out.println(expe1);
        Assert.assertEquals(expe1, "Please enter a mobile number");

        String expe = String.valueOf(driver.findElement(By.xpath("//*[@id='j_name-error']")).getText());
        System.out.println(expe);
        Assert.assertEquals(expe, "Please enter your name");
    }
    @Test(priority = 11)
    public void invalidpassandvalidmobandname() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teju89011@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("9560432706");
        rp.firstname("surya");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/1996";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if (monthDiff < 0) {
            isFuture = false;
            monthDiff = -1 * monthDiff;
        }
        for (int i = 0; i < monthDiff; i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("");
        rp.signin();
        String expe = String.valueOf(driver.findElement(By.xpath("//*[@id='j_password-error']")).getText());
        System.out.println(expe);
        Assert.assertEquals(expe, "Please enter a password");
    }
    @Test(priority = 12)
    public void invalidnameandvalidmobandpass() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teju89011@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("9560432706");
        rp.firstname("");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/1996";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if (monthDiff < 0) {
            isFuture = false;
            monthDiff = -1 * monthDiff;
        }
        for (int i = 0; i < monthDiff; i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("Surya@123");
        rp.signin();
        String expe = String.valueOf(driver.findElement(By.xpath("//*[@id='j_name-error']")).getText());
        System.out.println(expe);
        Assert.assertEquals(expe, "Please enter your name");
    }
    @Test(priority = 13)
    public void invalidnoandvalidnameandpas() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teju89011@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("");
        rp.firstname("surya");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/1996";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if (monthDiff < 0) {
            isFuture = false;
            monthDiff = -1 * monthDiff;
        }
        for (int i = 0; i < monthDiff; i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("Surya@123");
        rp.signin();
        String expe1 = String.valueOf(driver.findElement(By.xpath("//*[@id='j_number-error']")).getText());
        System.out.println(expe1);
        Assert.assertEquals(expe1, "Please enter a mobile number");
    }
    @Test(priority = 14)
    public void invalidnoandnameandpas() throws InterruptedException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("teju89011@gmail.com");
        lp.continueBtn();
        RegisterPage rp = new RegisterPage(driver);
        rp.numb("");
        rp.firstname("");
        WebElement calender = driver.findElement(By.id("j_dob"));
        calender.click();
        Thread.sleep(3000);
        String setDatestr = "24/05/1996";
        String currDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        if (monthDiff < 0) {
            isFuture = false;
            monthDiff = -1 * monthDiff;
        }
        for (int i = 0; i < monthDiff; i++) {
            if (isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
        }
        driver.findElement(By.xpath("//table/tbody/tr//td[@class='day'][text()='24']")).click();
        rp.password("");
        rp.signin();
        String expe1 = String.valueOf(driver.findElement(By.xpath("//*[@id='j_number-error']")).getText());
        System.out.println(expe1);
        Assert.assertEquals(expe1, "Please enter a mobile number");

        String expe = String.valueOf(driver.findElement(By.xpath("//*[@id='j_name-error']")).getText());
        System.out.println(expe);
        Assert.assertEquals(expe, "Please enter your name");

        String expe2 = String.valueOf(driver.findElement(By.xpath("//*[@id='j_password-error']")).getText());
        System.out.println(expe2);
        Assert.assertEquals(expe2, "Please enter a password");

    }















}
