package com.snapdeal.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    WebDriver driver;
    public Properties prop;
    public  Base() throws IOException {
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\snapdeal\\config\\config.properties");
        FileInputStream fis = new FileInputStream(propFile);
        prop.load(fis);
    }
    public WebDriver initializeBrowser (String browserName){

        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            driver=new EdgeDriver();
        } else if (browserName.equals("safari")) {
            driver=new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get(prop.getProperty("url"));
        return driver;

    }
}
