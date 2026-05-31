package com.expandtesting.notes.utils;

import com.expandtesting.notes.config.ConfigReader;
import org.testng.Assert;

public class PerformanceUtil {

    private PerformanceUtil() {
    }

    public static void assertResponseTime(long actualTimeMs, String apiName) {

        String threshold = ConfigReader.getProperty("api.response.threshold");
        long maxAllowedMs = threshold != null ? Long.parseLong(threshold) : 5000L;

        Assert.assertTrue(
                actualTimeMs < maxAllowedMs,
                apiName + " response time should be under " + maxAllowedMs
                        + " ms, but actual was " + actualTimeMs + " ms"
        );
    }
}
