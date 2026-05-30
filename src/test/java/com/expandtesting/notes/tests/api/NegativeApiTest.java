package com.expandtesting.notes.tests.api;

import com.expandtesting.notes.api.NotesApi;
import com.expandtesting.notes.utils.PerformanceUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeApiTest {

    @Test
    public void testGetNotesWithoutToken() {

        Response response =
                RestAssured.given()
                        .when()
                        .get("https://practice.expandtesting.com/notes/api/notes");

        Assert.assertTrue(
                response.statusCode() == 401
                        || response.statusCode() == 403,
                "Unauthorized request should fail"
        );
    }

    @Test
    public void testDeleteInvalidNote() {

        String fakeToken = "invalid-token";

        Response response =
                NotesApi.deleteNote(fakeToken, "123456");

        Assert.assertTrue(
                response.statusCode() >= 400,
                "Deleting invalid note should fail"
        );
    }

    @Test
    public void testInvalidLoginApi() {

        Response response =
                RestAssured.given()
                        .header("Content-Type", "application/json")
                        .body("""
                                {
                                  "email":"wrong@gmail.com",
                                  "password":"wrong123"
                                }
                                """)
                        .when()
                        .post("https://practice.expandtesting.com/notes/api/users/login");

        Assert.assertTrue(
                response.statusCode() == 400
                        || response.statusCode() == 401,
                "Invalid login should fail"
        );
    }
}
