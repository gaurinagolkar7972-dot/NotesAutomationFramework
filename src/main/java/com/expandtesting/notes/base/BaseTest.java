package com.expandtesting.notes.base;

import com.expandtesting.notes.config.ConfigReader;
import com.expandtesting.notes.drivers.BrowserFactory;
import com.expandtesting.notes.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        WebDriver driver = BrowserFactory.createDriver();
        DriverManager.setDriver(driver);

        DriverManager.getDriver()
                .manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(120));

        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().deleteAllCookies();

        DriverManager.getDriver()
                .get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}