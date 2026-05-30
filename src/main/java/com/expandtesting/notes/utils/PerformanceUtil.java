package com.expandtesting.notes.utils;

import com.expandtesting.notes.config.ConfigReader;
import org.testng.Assert;

public class PerformanceUtil {

    private PerformanceUtil() {
    }

    public static void assertResponseTime(long actualTimeMs, String apiName) {

        long maxAllowedMs = Long.parseLong(
                ConfigReader.getProperty("api.response.threshold")
        );

        Assert.assertTrue(
                actualTimeMs < maxAllowedMs,
                apiName + " response time should be under " + maxAllowedMs
                        + " ms, but actual was " + actualTimeMs + " ms"
        );
    }
}
