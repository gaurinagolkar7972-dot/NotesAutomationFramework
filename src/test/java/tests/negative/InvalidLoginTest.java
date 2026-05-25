package tests.negative;

import base.BaseTest;
import drivers.DriverManager;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {

        DriverManager.getDriver()
                .get("https://practice.expandtesting.com/notes/app/login");

        LoginPage loginPage = new LoginPage();

        loginPage.enterEmail("gaurinagolkar@gmail.com");
        loginPage.enterPassword("Wrong@123");
        loginPage.clickSignIn();

        System.out.println("Invalid Login Test Executed");
    }
}
