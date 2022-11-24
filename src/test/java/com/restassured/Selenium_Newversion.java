package com.restassured;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Selenium_Newversion {

    @Test
    public void checkSeleniumVersion() throws IOException {

      //  WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");


        driver.quit();

    }
}
