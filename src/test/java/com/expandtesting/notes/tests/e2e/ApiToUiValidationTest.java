package com.expandtesting.notes.tests.e2e;

import com.expandtesting.notes.api.NotesApi;
import com.expandtesting.notes.api.TokenManager;
import com.expandtesting.notes.base.BaseTest;
import com.expandtesting.notes.config.ConfigReader;
import com.expandtesting.notes.models.NotePayload;
import com.expandtesting.notes.pages.HomePage;
import com.expandtesting.notes.pages.LoginPage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiToUiValidationTest extends BaseTest {

    @Test
    public void testApiCreatedNoteAppearsInUi() {

        String title = "Hybrid API Note " + System.currentTimeMillis();
        String description = "Created from API and verified in UI";
        String category = "Work";

        String token = TokenManager.getToken();

        NotePayload payload =
                new NotePayload(title, description, category);

        Response createResponse =
                NotesApi.createNote(token, payload);

        createResponse.then().statusCode(200);

        LoginPage loginPage = new LoginPage();
        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );

        HomePage homePage = new HomePage();

        Assert.assertTrue(
                homePage.isPageLoaded(),
                "Home page should load after login"
        );

        Assert.assertTrue(
                homePage.isNoteVisible(title),
                "API-created note should be visible in UI"
        );
    }
}
