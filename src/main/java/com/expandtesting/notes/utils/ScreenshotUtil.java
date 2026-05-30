package com.expandtesting.notes.utils;

import com.expandtesting.notes.drivers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static String capture(String testName) {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String path =
                "screenshots/" + testName + "_" + timestamp + ".png";

        File source =
                ((TakesScreenshot) DriverManager.getDriver())
                        .getScreenshotAs(OutputType.FILE);

        File destination = new File(path);

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            throw new RuntimeException("Unable to save screenshot", e);
        }

        return destination.getAbsolutePath();
    }
}
