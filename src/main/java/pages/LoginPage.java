package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import drivers.DriverManager;
import org.openqa.selenium.By;

public class LoginPage {

    private final By emailField = By.name("email");
    private final By passwordField = By.name("password");
    private final By signInButton = By.xpath("//button[@type='submit']");

    public void enterEmail(String email) {
        DriverManager.getDriver()
                .findElement(emailField)
                .sendKeys(email);
    }

    public void enterPassword(String password) {
        DriverManager.getDriver()
                .findElement(passwordField)
                .sendKeys(password);
    }

    public void clickSignIn() {

        WebElement button =
                DriverManager.getDriver()
                        .findElement(signInButton);

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true);", button);
        js.executeScript("arguments[0].click();", button);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
    }
}
