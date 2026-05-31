package com.expandtesting.notes.tests.e2e;

import com.expandtesting.notes.api.NotesApi;
import com.expandtesting.notes.api.TokenManager;
import com.expandtesting.notes.base.BaseTest;
import com.expandtesting.notes.config.ConfigReader;
import com.expandtesting.notes.drivers.DriverManager;
import com.expandtesting.notes.models.NotePayload;
import com.expandtesting.notes.pages.LoginPage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiDeleteReflectsInUITest extends BaseTest {

    @Test
    public void testApiDeletedNoteDisappearsFromUI() throws InterruptedException {

        String token = TokenManager.getToken();

        String title =
                "API Delete UI Note " + System.currentTimeMillis();

        NotePayload payload =
                new NotePayload(
                        title,
                        "Created from API and deleted from API",
                        "Home"
                );

        Response createResponse =
                NotesApi.createNote(token, payload);

        createResponse.then().statusCode(200);

        String noteId =
                createResponse.jsonPath().getString("data.id");

        Assert.assertNotNull(
                noteId,
                "Created note ID should not be null"
        );

        LoginPage loginPage = new LoginPage();

        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );

        Response deleteResponse =
                NotesApi.deleteNote(token, noteId);

        deleteResponse.then().statusCode(200);

        Thread.sleep(3000);

        DriverManager.getDriver().navigate().refresh();

        Thread.sleep(3000);

        Assert.assertFalse(
                DriverManager.getDriver()
                        .getPageSource()
                        .contains(title),
                "API-deleted note should disappear from UI"
        );
    }
}