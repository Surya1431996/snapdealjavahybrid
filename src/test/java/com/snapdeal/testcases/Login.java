package com.snapdeal.testcases;

import com.snapdeal.base.Base;
import com.snapdeal.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class Login extends Base {

    public Login() throws IOException {
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
        lp.registerPage();
        driver.switchTo().frame(0);
    }

    @AfterMethod
    public void tearDown(){
        if (driver!=null) {
            driver.quit();
        }
    }

    @Test (priority = 1)
    public void verifyWithvalidCredentials() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("9560432706");
        lp.continueBtn2();
        lp.otpBtn();
        String pagetitle = driver.getTitle();
        System.out.println(pagetitle);
        Assert.assertEquals(pagetitle, "Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items");
        driver.close();
    }

    @Test (priority = 2)
    public void verifyNotRegisteredFields() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("asshahi1991@gmail.com");
        lp.continueBtn2();
        String v1 = driver.findElement(By.xpath("//*[@id='login-register-modal']/div/div[10]/div[1]/p")).getText();
        System.out.println(v1);
        Assert.assertEquals(v1, "Create an account on Snapdeal");
        driver.close();
    }

    @Test (priority = 3)
    public void notvalidfileds() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("ast.com");
        lp.continueBtn2();
        String expe = String.valueOf(driver.findElement(By.id("userName-error")).getText());
        System.out.println(expe);
        Assert.assertEquals(expe, "Please enter a valid mobile number or email");
    }

    @Test (priority = 4)
    public void loginwithemptyfileds () throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.userName("");
        lp.continueBtn2();
        String expe1 = String.valueOf(driver.findElement(By.id("userName-error")).getText());
        System.out.println(expe1);
        Assert.assertEquals(expe1, "Please enter your mobile number or email");
    }

    @Test (priority = 5)
    public void loginwithUnRegistermail() throws InterruptedException {
        mainWindow = driver.getWindowHandle();
        LoginPage lp = new LoginPage(driver);
        lp.googlebtn();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        Thread.sleep(3000);
        lp.mailId("ast98490984901@gmail.com");
        lp.gmailNext();
        lp.passwordId("surya@123");
        lp.passNext();
        driver.switchTo().window(mainWindow);
        driver.switchTo().frame(0);
        String v2 = driver.findElement(By.xpath("//*[@id='login-register-modal']/div/div[10]/div[1]/p")).getText();
        System.out.println(v2);
        Assert.assertEquals(v2, "Create an account on Snapdeal");
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void loginwithregistermail() throws InterruptedException {
        mainWindow = driver.getWindowHandle();
        LoginPage lp = new LoginPage(driver);
        lp.googlebtn();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        Thread.sleep(3000);
        lp.mailId("ast984904@gmail.com");
        lp.gmailNext();
        lp.passwordId("surya@123");
        lp.passNext();
        driver.switchTo().window(mainWindow);
        String pagetitle = driver.getTitle();
        System.out.println(pagetitle);
        Assert.assertEquals(pagetitle, "Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items");
        Thread.sleep(2000);
    }









}
