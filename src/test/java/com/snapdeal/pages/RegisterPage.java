package com.snapdeal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[2]/span[2]/a")
    private WebElement regis;

    public void register() throws InterruptedException {
        regis.click();
        Thread.sleep(3000);
    }
    @FindBy(id ="j_number")
    private WebElement number;

    public void numb(String num) throws InterruptedException {
        number.click();
        number.sendKeys(num);
        Thread.sleep(3000);
    }
    @FindBy(id ="j_name")
    private WebElement name;

    public void firstname(String nam) throws InterruptedException {
        name.click();
        name.sendKeys(nam);
        Thread.sleep(3000);
    }
    @FindBy(id ="j_password")
    private WebElement pass;

    public void password(String ps) throws InterruptedException {
        pass.click();
        pass.sendKeys(ps);
        Thread.sleep(3000);
    }

    @FindBy(id ="userSignup")
    private WebElement sign;

    public void signin() throws InterruptedException {
        sign.click();
        Thread.sleep(5000);
    }
}
