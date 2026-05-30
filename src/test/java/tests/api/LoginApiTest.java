package tests.api;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class LoginApiTest {

    @Test
    public void loginApiTest() {

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

        System.out.println("Token = " + token);
    }
}
