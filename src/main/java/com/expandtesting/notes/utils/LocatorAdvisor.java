package com.expandtesting.notes.utils;

public class LocatorAdvisor {

    private LocatorAdvisor() {
    }

    public static String suggest(String locatorType) {

        switch (locatorType.toLowerCase()) {

            case "id":
                return "Preferred locator: ID (fast and stable)";

            case "css":
                return "Use CSS selector when ID is unavailable";

            case "xpath":
                return "XPath should be used as a fallback locator";

            default:
                return "No recommendation available";
        }
    }
}