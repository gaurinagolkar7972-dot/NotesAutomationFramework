package com.expandtesting.notes.utils;

public class FailureAnalyzer {

    private FailureAnalyzer() {
    }

    public static String analyze(String errorMessage) {

        if (errorMessage.contains("TimeoutException")) {
            return "Possible cause: slow page load or unstable browser session. Suggested fix: increase wait time or retry execution.";
        }

        if (errorMessage.contains("NoSuchElementException")) {
            return "Possible cause: locator changed or element not visible. Suggested fix: verify locator and add explicit wait.";
        }

        if (errorMessage.contains("ElementClickInterceptedException")) {
            return "Possible cause: popup, ad iframe, or overlay blocking the element. Suggested fix: scroll element into view or use JavaScript click.";
        }

        if (errorMessage.contains("AssertionError")) {
            return "Possible cause: expected and actual results mismatch. Suggested fix: verify test data, API response, or synchronization delay.";
        }

        return "No specific suggestion available. Check logs, screenshots, and application response.";
    }
}