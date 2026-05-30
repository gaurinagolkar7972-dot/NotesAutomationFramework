package com.expandtesting.notes.tests.api;

import com.expandtesting.notes.api.BaseApi;
import com.expandtesting.notes.api.TokenManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetInvalidNoteApiTest {

    @Test
    public void testGetInvalidNote() {

        String token = TokenManager.getToken();

        Response response =
                given()
                        .spec(BaseApi.requestSpec())
                        .header("x-auth-token", token)
                        .when()
                        .get("/notes/INVALID_NOTE_ID");

        Assert.assertTrue(
                response.statusCode() == 404
                        || response.statusCode() == 400,
                "Invalid note request should fail"
        );
    }
}