package com.snapdeal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Itemcheckoutpage {
    WebDriver driver;

    public Itemcheckoutpage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name ="keyword")
    private WebElement product;

    public void validproduct() throws InterruptedException {
        product.click();
        Thread.sleep(3000);
        product.sendKeys("Laptop");
        Thread.sleep(3000);
    }
    @FindBy(xpath ="//*[@id='sdHeader']/div[4]/div[2]/div/div[2]/button")
    private WebElement search;

    public void searchbtn() throws InterruptedException {
        search.click();
        Thread.sleep(3000);

    }
    @FindBy(xpath ="//*[@id='js-21-nav']/li[1]/div")
    private WebElement searchit;

    public void searchitem() throws InterruptedException {
        searchit.click();
        Thread.sleep(3000);
    }
    @FindBy(id ="633245836101")
    private WebElement product1;

    public void productitem() throws InterruptedException {
        product1.click();
        Thread.sleep(3000);

    }
    @FindBy(id ="buy-button-id")
    private WebElement buy;

    public void buyButton() throws InterruptedException {
        buy.click();
        Thread.sleep(3000);

    }
    @FindBy(id ="gplogin")
    private WebElement glogin;

    public void loginButton() throws InterruptedException {
        glogin.click();
        Thread.sleep(3000);
    }
    @FindBy(xpath="//input[@id='zip']")
    private WebElement pin;

    public void pinEnter() throws InterruptedException {
        pin.clear();
        Thread.sleep(1000);
        pin.click();
        Thread.sleep(1000);
        pin.sendKeys("201307");
        Thread.sleep(3000);

    }
    @FindBy(id ="fullName")
    private WebElement nam;
    public void name() throws InterruptedException {
        nam.click();
        Thread.sleep(1000);
        nam.sendKeys("surya");
        Thread.sleep(3000);
    }
    @FindBy(id ="address")
    private WebElement add;
    public void address() throws InterruptedException {
        add.click();
        Thread.sleep(1000);
        add.sendKeys("noida");
        Thread.sleep(3000);
    }
    @FindBy(id ="nearestLandmark")
    private WebElement lm;
    public void landmark() throws InterruptedException {
        lm.click();
        Thread.sleep(1000);
        lm.sendKeys("hospital");
        Thread.sleep(3000);
    }
    @FindBy(id ="alternateMobile")
    private WebElement alm;
    public void altmobile() throws InterruptedException {
        alm.click();
        Thread.sleep(1000);
        alm.sendKeys("8012345678");
        Thread.sleep(3000);
    }
    @FindBy(xpath ="//*[@id='shipping-address-form']/div/div[10]/div/div[1]/label/span[1]")
    private WebElement radio;
    public void addtype() throws InterruptedException {
        radio.click();
        Thread.sleep(1000);
    }
    @FindBy(xpath ="//*[@id='shipping-address-form']/div/div[10]/div/div[1]")
    private WebElement agg;
    public void aggre() throws InterruptedException {
        agg.click();
        Thread.sleep(1000);
    }
    @FindBy(id ="delivery-modes-continue")
    private WebElement dcont;
    public void deliveryCont() throws InterruptedException {
        dcont.click();
        Thread.sleep(1000);
    }
    @FindBy(xpath ="//*[@id='make-payment']")
    private WebElement pay;
    public void payBtn() throws InterruptedException {
        pay.click();
        Thread.sleep(3000);
    }
    @FindBy(xpath ="//*[@id='payment-nav-id']/div[4]")
    private WebElement cod;
    public void codBtn() throws InterruptedException {
        cod.click();
        Thread.sleep(3000);
    }
    @FindBy(xpath ="//*[@id='make-payment-button']")
    private WebElement place;
    public void placeOrder() throws InterruptedException {
        place.click();
        Thread.sleep(3000);
    }
    @FindBy(name ="keyword")
    private WebElement sear;
    public void searitem() throws InterruptedException {
        sear.click();
        Thread.sleep(1000);
        sear.sendKeys("laptops");
        Thread.sleep(3000);
    }
    @FindBy(xpath ="//*[@id='payment-nav-id']/div[2]")
    private WebElement debit;
    public void debitCard() throws InterruptedException {
        debit.click();
        Thread.sleep(3000);
    }
    @FindBy(xpath ="//*[@id='creditcard-payment-form']/div/div[1]/div[2]/input")
    private WebElement dc;
    public void dcNo() throws InterruptedException {
        dc.click();
        Thread.sleep(2000);
        dc.sendKeys("5260990218592810");
        Thread.sleep(4000);
    }
    @FindBy(xpath ="//select[@name='expMonth']")
    private WebElement mn;
    public void month() throws InterruptedException {
        Thread.sleep(2000);
        Select select = new Select(mn);
        select.selectByValue("4");
        Thread.sleep(4000);
    }
    @FindBy(xpath ="//select[@name='expYear']")
    private WebElement ye;
    public void year() throws InterruptedException {
        Thread.sleep(2000);
        Select select = new Select(ye);
        select.selectByValue("26");
        Thread.sleep(4000);
    }
    @FindBy(xpath ="//*[@id='creditcard-payment-form']/div/div[3]/div[2]/div[2]/input")
    private WebElement cv;
    public void cvv() throws InterruptedException {
        cv.click();
        Thread.sleep(2000);
        cv.sendKeys("861");
        Thread.sleep(4000);
    }
    @FindBy(xpath ="//*[@id='creditcard-continue']")
    private WebElement pp;
    public void paypage() throws InterruptedException {
        pp.click();
        Thread.sleep(2000);
    }
    @FindBy(xpath ="//*[@id='securePay']")
    private WebElement ppa;
    public void paypage1() throws InterruptedException {
        ppa.click();
        Thread.sleep(3000);
    }
    @FindBy(xpath ="//*[@id='payment-nav-id']/div[3]")
    private WebElement nb;
    public void netBank() throws InterruptedException {
        nb.click();
        Thread.sleep(3000);
    }
    @FindBy(xpath ="//*[@id='nb-mode']/div[1]/div[2]/div[2]/label/span[1]")
    private WebElement bs;
    public void bankSelect() throws InterruptedException {

        bs.click();
        Thread.sleep(2000);
    }
    @FindBy(xpath ="//*[@id='shipping-address-form']/div/div[11]/div/label/span/span")
    private WebElement def;
    public void defaultEnter() throws InterruptedException {
        def.click();
        Thread.sleep(3000);

    }
    @FindBy(xpath ="//*[@id='mobile']")
    private WebElement n;
    public void number() throws InterruptedException {
        n.click();
        n.sendKeys("9560432706");
        Thread.sleep(3000);

    }


}
