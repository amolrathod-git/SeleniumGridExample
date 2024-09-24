package com.org.mydistributedtests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class TestOne extends Base{
    public WebDriver driver = null;
    @Test
    public void testOne()  {

        // launch application
        driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");

        // get page title
        System.out.println("Page title is: " + driver.getTitle() + " obtained from testOne");
    }
    @BeforeMethod
    public void setup() throws IOException {
        driver = setBrowser("chrome");
    }
    @AfterMethod
    public void tearDown() {

        // quitting browser
        driver.quit();
    }

}
