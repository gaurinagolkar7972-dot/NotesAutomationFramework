package com.expandtesting.notes.tests.ui;

import com.expandtesting.notes.base.BaseTest;
import com.expandtesting.notes.config.ConfigReader;
import com.expandtesting.notes.drivers.DriverManager;
import com.expandtesting.notes.pages.AddNotePage;
import com.expandtesting.notes.pages.HomePage;
import com.expandtesting.notes.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefreshPersistenceUITest extends BaseTest {

    @Test
    public void testNotePersistsAfterRefresh() {

        LoginPage loginPage = new LoginPage();

        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );

        HomePage homePage = new HomePage();

        homePage.goToAddNote();

        String title =
                "Refresh Note " + System.currentTimeMillis();

        AddNotePage addNotePage = new AddNotePage();

        addNotePage.createNote(
                title,
                "Persistence validation",
                "Home"
        );

        DriverManager.getDriver().navigate().refresh();

        Assert.assertTrue(
                homePage.isNoteVisible(title),
                "Note should remain visible after refresh"
        );
    }
}