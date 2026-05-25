package tests.ui;

import base.BaseTest;
import drivers.DriverManager;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        DriverManager.getDriver()
                .get("https://practice.expandtesting.com/notes/app/login");

        LoginPage loginPage = new LoginPage();

        loginPage.enterEmail("gaurinagolkar@gmail.com");

        loginPage.enterPassword("Gauri@123");

        loginPage.clickSignIn();

        System.out.println("Login Successful");
    }
}
