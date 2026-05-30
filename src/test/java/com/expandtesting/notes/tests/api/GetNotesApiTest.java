package com.expandtesting.notes.tests.api;

import com.expandtesting.notes.api.NotesApi;
import com.expandtesting.notes.api.TokenManager;
import com.expandtesting.notes.utils.JsonSchemaValidatorUtil;
import com.expandtesting.notes.utils.PerformanceUtil;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetNotesApiTest {

    @Test
    public void testGetNotesReturnsList() {

        String token = TokenManager.getToken();

        Response response = NotesApi.getNotes(token);

        response.then().statusCode(200);

        PerformanceUtil.assertResponseTime(
                response.getTime(),
                "GET /notes"
        );

        JsonSchemaValidatorUtil.validate(
                response,
                "schemas/notes-schema.json"
        );
    }
}
