package tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class UnauthorizedApiTest {

    @Test
    public void unauthorizedApiTest() {

        RestAssured
                .given()
                .header("x-auth-token", "invalidtoken123")
                .get("https://practice.expandtesting.com/notes/api/notes")
                .then()
                .statusCode(401);

        System.out.println("Unauthorized API Passed");
    }
}
