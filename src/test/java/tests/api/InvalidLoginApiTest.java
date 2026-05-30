package tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class InvalidLoginApiTest {

    @Test
    public void invalidLoginTest() {

        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body("""
                        {
                          "email":"gaurinagolkar@gmail.com",
                          "password":"WrongPassword123"
                        }
                        """)
                .post("https://practice.expandtesting.com/notes/api/users/login")
                .then()
                .statusCode(401);

        System.out.println("Invalid Login API Passed");
    }
}
