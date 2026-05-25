package tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class CreateNoteApiTest {

    @Test
    public void createNoteApiTest() {

        String token = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body("""
                        {
                          "email":"gaurinagolkar@gmail.com",
                          "password":"Gauri@123"
                        }
                        """)
                .post("https://practice.expandtesting.com/notes/api/users/login")
                .jsonPath()
                .getString("data.token");

        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-auth-token", token)
                .body("""
                        {
                          "title":"API Note",
                          "description":"Created using Rest Assured",
                          "category":"Work"
                        }
                        """)
                .post("https://practice.expandtesting.com/notes/api/notes")
                .then()
                .statusCode(200);

        System.out.println("Create Note API Passed");
    }
}