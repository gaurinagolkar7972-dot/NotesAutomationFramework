package com.expandtesting.notes.drivers;

import com.expandtesting.notes.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {

    public static WebDriver createDriver() {

        String browser =
                ConfigReader.getProperty("browser");

        if (browser == null) {
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {

            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}
