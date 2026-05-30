package com.expandtesting.notes.api;

import com.expandtesting.notes.config.ConfigReader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TokenManager {

    private static String token;

    private TokenManager() {
    }

    public static String getToken() {

        if (token == null) {

            Response response =
                    given()
                            .spec(BaseApi.requestSpec())
                            .body("""
                                    {
                                      "email": "%s",
                                      "password": "%s"
                                    }
                                    """.formatted(
                                    ConfigReader.getProperty("email"),
                                    ConfigReader.getProperty("password")
                            ))
                            .when()
                            .post("/users/login");

            response.then().statusCode(200);

            token = response.jsonPath().getString("data.token");
        }

        return token;
    }
}
