package tests.ui;

import base.BaseTest;
import drivers.DriverManager;
import org.testng.annotations.Test;
import pages.CreateNotePage;
import pages.HomePage;
import pages.LoginPage;

public class CreateNoteTest extends BaseTest {

    @Test
    public void createNoteTest() {

        DriverManager.getDriver()
                .get("https://practice.expandtesting.com/notes/app/login");

        LoginPage loginPage = new LoginPage();

        loginPage.enterEmail("gaurinagolkar@gmail.com");
        loginPage.enterPassword("Gauri@123");
        loginPage.clickSignIn();

        HomePage homePage = new HomePage();
        homePage.clickAddNote();

        CreateNotePage createNotePage = new CreateNotePage();

        createNotePage.enterTitle("Office Work");
        createNotePage.enterDescription("Automation Testing Project");
        createNotePage.clickCreate();

        System.out.println("Note Created Successfully");
    }
}
