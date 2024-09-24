package com.org.mydistributedtests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;
import java. util. *;


public class Base {
    public WebDriver setBrowser(String browserName) throws MalformedURLException, IOException {
        WebDriver driver = null;
        DesiredCapabilities dc = new DesiredCapabilities();


        Properties prop =new Properties();
        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\org\\mydistributedtests\\resources\\GlobalData.properties");
        prop.load(fis);
        String hubURL= prop.getProperty("hubURL");


        if(browserName.equalsIgnoreCase("chrome")) {
            dc.setPlatform(Platform.ANY);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("se:name", "Test on Grid - Chrome");
            dc.setCapability(ChromeOptions.CAPABILITY, chromeOptions );
            driver = new RemoteWebDriver(new URL(hubURL),dc);

        } else if (browserName.equalsIgnoreCase("edge")) {
            dc.setPlatform(Platform.ANY);
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setCapability("se:name", "Test on Grid - Edge");
            dc.setCapability(EdgeOptions.CAPABILITY, edgeOptions );
            driver = new RemoteWebDriver(new URL(hubURL),dc);
        }

        else if (browserName.equalsIgnoreCase("firefox")) {
            dc.setPlatform(Platform.WIN11);

            FirefoxOptions firefoxOptions = new FirefoxOptions();

            firefoxOptions.setCapability("se:name", "Test on Grid - firefox");
            dc.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
            driver = new RemoteWebDriver(new URL(hubURL),dc);

        }


        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }


}
