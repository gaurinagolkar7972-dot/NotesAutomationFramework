package tests.negative;

import base.BaseTest;
import drivers.DriverManager;
import org.testng.annotations.Test;
import pages.LoginPage;

public class EmptyFieldTest extends BaseTest {

    @Test
    public void emptyFieldTest() {

        DriverManager.getDriver()
                .get("https://practice.expandtesting.com/notes/app/login");

        LoginPage loginPage = new LoginPage();

        loginPage.clickSignIn();

        System.out.println("Empty Field Validation Executed");
    }
}
