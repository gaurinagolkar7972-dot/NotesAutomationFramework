package com.expandtesting.notes.tests.api;

import com.expandtesting.notes.api.BaseApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetNotesWithoutTokenTest {

    @Test
    public void testGetNotesWithoutToken() {

        Response response =
                given()
                        .spec(BaseApi.requestSpec())
                        .when()
                        .get("/notes");

        Assert.assertTrue(
                response.statusCode() == 401
                        || response.statusCode() == 403,
                "GET notes without token should fail"
        );
    }
}