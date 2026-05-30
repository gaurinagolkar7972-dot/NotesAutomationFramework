package com.expandtesting.notes.utils;

import com.expandtesting.notes.drivers.DriverManager;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        try {

            if (DriverManager.getDriver() != null) {

                String screenshotPath =
                        ScreenshotUtil.capture(result.getName());

                Allure.addAttachment(
                        "Failure Screenshot",
                        new FileInputStream(screenshotPath)
                );
            }

            String suggestion =
                    FailureAnalyzer.analyze(
                            result.getThrowable().toString()
                    );

            System.out.println(
                    "AI Failure Suggestion: " + suggestion
            );

            Allure.addAttachment(
                    "AI Failure Suggestion",
                    suggestion
            );

        } catch (Exception e) {
            System.out.println(
                    "Unable to capture failure evidence: "
                            + e.getMessage()
            );
        }
    }
}