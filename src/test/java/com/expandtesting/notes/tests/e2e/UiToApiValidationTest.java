package com.expandtesting.notes.tests.e2e;

import com.expandtesting.notes.api.NotesApi;
import com.expandtesting.notes.api.TokenManager;
import com.expandtesting.notes.base.BaseTest;
import com.expandtesting.notes.config.ConfigReader;
import com.expandtesting.notes.pages.AddNotePage;
import com.expandtesting.notes.pages.HomePage;
import com.expandtesting.notes.pages.LoginPage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class UiToApiValidationTest extends BaseTest {

    @Test
    public void testUiCreatedNoteAppearsInApi() throws InterruptedException {

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

        homePage.goToAddNote();

        AddNotePage addNotePage = new AddNotePage();

        String title =
                "Hybrid UI Note " + System.currentTimeMillis();

        String description =
                "Created from UI and verified using API";

        String category = "Home";

        addNotePage.createNote(
                title,
                description,
                category
        );

        Thread.sleep(5000);

        String token = TokenManager.getToken();

        Response response =
                NotesApi.getNotes(token);

        response.then().statusCode(200);

        List<Map<String, Object>> notes =
                response.jsonPath().getList("data");

        boolean noteFound =
                notes.stream().anyMatch(note ->
                        title.equals(note.get("title"))
                                && description.equals(note.get("description"))
                                && category.equals(note.get("category"))
                );

        Assert.assertTrue(
                noteFound,
                "UI-created note should appear in API response"
        );
    }
}