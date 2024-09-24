package com.org.mydistributedtests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class TestThree extends Base{
    public WebDriver driver = null;
    @Test
    public void testThree() {

        // launch application
        driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");

        // get page title
        System.out.println("Page title is: " + driver.getTitle() + " obtained from testThree");
    }
    @BeforeMethod
    public void setup() throws IOException {
        driver = setBrowser("firefox");
    }

    @AfterMethod
    public void tearDown() {

        // quitting browser
        driver.quit();
    }
}
