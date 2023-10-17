package com.snapdeal.testcases;

import com.snapdeal.base.Base;
import com.snapdeal.pages.Itemcheckoutpage;
import com.snapdeal.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


import java.io.IOException;
import java.util.Set;

public class Itemcheckout extends Base {
    public Itemcheckout() throws IOException {
        super();
    }

    public WebDriver driver;
    String mainWindow;
    String originalWindow1;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = initializeBrowser(prop.getProperty("browserName"));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void checkoutwithCOD() throws InterruptedException, IOException {
        String actualTitle = "Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items";
        if (actualTitle.equals(driver.getTitle())) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        Itemcheckoutpage iO = new Itemcheckoutpage(driver);
        iO.validproduct();
        iO.searchbtn();
        String pagetitle = driver.getTitle();
        System.out.println(pagetitle);
        Assert.assertEquals(pagetitle, "Snapdeal.com - Online shopping India- Discounts - shop Online Perfumes, Watches, sunglasses etc");
        Thread.sleep(2000);
        iO.searchitem();
        String pagetitle1 = driver.getTitle();
        System.out.println(pagetitle1);
        Assert.assertEquals(pagetitle1, "Snapdeal.com - Online shopping India- Discounts - shop Online Perfumes, Watches, sunglasses etc");
        Thread.sleep(2000);
        iO.productitem();
        String originalWindow = driver.getWindowHandle();
        driver.close();
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String pagetitle2 = driver.getTitle();
        System.out.println(pagetitle2);
        Assert.assertEquals(pagetitle2, "Buy HOMETALES 25 in 1 Screwdriver Set, Multi-Pocket Repair Tool Kit for Mobiles|Laptops|Electronics Online at Best Price in India - Snapdeal");
        Thread.sleep(2000);
        iO.buyButton();

        String pagetitle3 = driver.getTitle();
        System.out.println(pagetitle3);
        Assert.assertEquals(pagetitle3, "Snapdeal Cart Checkout");

        iO.loginButton();
        originalWindow1 = driver.getWindowHandle();
        Set<String> allHandles1 = driver.getWindowHandles();
        for (String handle1 : allHandles1) {
            if (!handle1.equals(originalWindow1)) {
                driver.switchTo().window(handle1);
                break;
            }
        }
        LoginPage lp = new LoginPage(driver);
        lp.mailId("ast984904@gmail.com");
        lp.gmailNext();
        lp.passwordId("surya@123");
        lp.passNext();
        driver.switchTo().window(originalWindow1);
        iO.pinEnter();
        iO.name();
        iO.address();
        iO.landmark();
        iO.altmobile();
        iO.addtype();
        iO.aggre();
        iO.defaultEnter();
        iO.deliveryCont();
        iO.payBtn();
        iO.codBtn();
        iO.placeOrder();
        String pagetitle4 = driver.getTitle();
        System.out.println(pagetitle4);
        Assert.assertEquals(pagetitle4, "Snapdeal Order Confirmation");
    }

    @Test(priority = 2)
    public void checkoutwithDC() throws InterruptedException, IOException {
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
        lp.googlebtn();
        mainWindow = driver.getWindowHandle();
        Set<String> allHandles1 = driver.getWindowHandles();
        for (String handle1 : allHandles1) {
            if (!handle1.equals(mainWindow)) {
                driver.switchTo().window(handle1);
                break;
            }
        }
        lp.mailId("ast984904@gmail.com");
        lp.gmailNext();
        lp.passwordId("surya@123");
        lp.passNext();
        driver.switchTo().window(mainWindow) ;
        Itemcheckoutpage io = new Itemcheckoutpage(driver);
        io.searitem();
        io.searchbtn();
        String pagetitle = driver.getTitle();
        System.out.println(pagetitle);
        Assert.assertEquals(pagetitle, "Snapdeal.com - Online shopping India- Discounts - shop Online Perfumes, Watches, sunglasses etc");
        Thread.sleep(2000);
        io.searchitem();
        String pagetitle2 = driver.getTitle();
        System.out.println(pagetitle2);
        Assert.assertEquals(pagetitle2, "Snapdeal.com - Online shopping India- Discounts - shop Online Perfumes, Watches, sunglasses etc");
        Thread.sleep(2000);
        io.productitem();
        String originalWindow = driver.getWindowHandle();
        driver.close();
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String pagetitle3 = driver.getTitle();
        System.out.println(pagetitle3);
        Assert.assertEquals(pagetitle3, "Buy HOMETALES 25 in 1 Screwdriver Set, Multi-Pocket Repair Tool Kit for Mobiles|Laptops|Electronics Online at Best Price in India - Snapdeal");
        Thread.sleep(2000);
        io.buyButton();
        String pagetitle4 = driver.getTitle();
        System.out.println(pagetitle4);
        Assert.assertEquals(pagetitle4, "Snapdeal Cart Checkout");
        io.pinEnter();
        io.name();
        io.address();
        io.landmark();
        io.altmobile();
        io.addtype();
        io.aggre();
        io.defaultEnter();
        io.deliveryCont();
        io.payBtn();
        io.debitCard();
        io.dcNo();
        io.month();
        io.year();
        io.cvv();
        io.paypage();
        io.paypage1();
    }

    @Test(priority = 3)
    public void checkoutwithNB() throws InterruptedException, IOException {
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
        lp.googlebtn();
        mainWindow = driver.getWindowHandle();
        Set<String> allHandles1 = driver.getWindowHandles();
        for (String handle1 : allHandles1) {
            if (!handle1.equals(mainWindow)) {
                driver.switchTo().window(handle1);
                break;
            }
        }
        lp.mailId("ast984904@gmail.com");
        lp.gmailNext();
        lp.passwordId("surya@123");
        lp.passNext();
        driver.switchTo().window(mainWindow) ;
        Itemcheckoutpage io = new Itemcheckoutpage(driver);
        io.searitem();
        io.searchbtn();
        String pagetitle = driver.getTitle();
        System.out.println(pagetitle);
        Assert.assertEquals(pagetitle, "Snapdeal.com - Online shopping India- Discounts - shop Online Perfumes, Watches, sunglasses etc");
        Thread.sleep(2000);
        io.searchitem();
        String pagetitle2 = driver.getTitle();
        System.out.println(pagetitle2);
        Assert.assertEquals(pagetitle2, "Snapdeal.com - Online shopping India- Discounts - shop Online Perfumes, Watches, sunglasses etc");
        Thread.sleep(2000);
        io.productitem();
        String originalWindow = driver.getWindowHandle();
        driver.close();
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String pagetitle3 = driver.getTitle();
        System.out.println(pagetitle3);
        Assert.assertEquals(pagetitle3, "Buy HOMETALES 25 in 1 Screwdriver Set, Multi-Pocket Repair Tool Kit for Mobiles|Laptops|Electronics Online at Best Price in India - Snapdeal");
        Thread.sleep(2000);
        io.buyButton();
        String pagetitle4 = driver.getTitle();
        System.out.println(pagetitle4);
        Assert.assertEquals(pagetitle4, "Snapdeal Cart Checkout");
        io.pinEnter();
        io.name();
        io.address();
        io.landmark();
        io.altmobile();
        io.addtype();
        io.aggre();
        io.defaultEnter();
        io.deliveryCont();
        io.payBtn();
        io.netBank();
        io.bankSelect();
        io.placeOrder();
        String pagetitle5 = driver.getTitle();
        System.out.println(pagetitle5);
        Assert.assertEquals(pagetitle5, "Welcome to HDFC Bank Direct Pay");

    }







    }

