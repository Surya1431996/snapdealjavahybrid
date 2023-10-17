package com.snapdeal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]")
    private WebElement accountMenu;

    public void clickAccountmenu() throws InterruptedException {
        accountMenu.click();
        Thread.sleep(1000);
    }
    @FindBy(xpath ="//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[2]/span[2]/a")
    private WebElement register;

    public void registerPage() throws InterruptedException {
        register.click();
        Thread.sleep(1000);
    }
    @FindBy(id ="userName")
    private WebElement mobileField;

    public void userName(String email) throws InterruptedException {
        mobileField.sendKeys(email);
        Thread.sleep(2000);
    }
    @FindBy(id ="checkUser")
    private WebElement contBtn;

    public void continueBtn() throws InterruptedException {
        contBtn.click();
        Thread.sleep(2000);
    }
    public void continueBtn2() throws InterruptedException {
        contBtn.click();
        Thread.sleep(20000);
    }

    public void continueBtn1() throws InterruptedException {
        contBtn.click();
        Thread.sleep(1000);
    }
    @FindBy(id ="loginUsingOtp")
    private WebElement otp;

    public void otpBtn() throws InterruptedException {
        otp.click();
        Thread.sleep(5000);
    }


    @FindBy(id = "googleUserLogin")
    private WebElement google;

    public void googlebtn() throws InterruptedException {
        google.click();
        Thread.sleep(2000);
    }
    @FindBy(id ="identifierId")
    private WebElement emailField;

    public void mailId(String mailText) throws InterruptedException {
        emailField.click();
        emailField.sendKeys(mailText);
        Thread.sleep(3000);
    }
    @FindBy(xpath = "//*[@id='identifierNext']/div/button")
    private WebElement googleNext;

    public void gmailNext() throws InterruptedException {
        googleNext.click();
        Thread.sleep(2000);
    }
    @FindBy(xpath ="//*[@id='password']/div[1]/div/div[1]/input")
    private WebElement passwordField;

    public void passwordId(String password) throws InterruptedException {
        passwordField.sendKeys(password);
        Thread.sleep(3000);
    }
    @FindBy(xpath = "//*[@id='passwordNext']/div/button")
    private WebElement passNext;

    public void passNext() throws InterruptedException {
        passNext.click();
        Thread.sleep(10000);
    }







}
