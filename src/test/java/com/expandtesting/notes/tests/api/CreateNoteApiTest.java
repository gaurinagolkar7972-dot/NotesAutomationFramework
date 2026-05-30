package com.expandtesting.notes.tests.api;

import com.expandtesting.notes.api.NotesApi;
import com.expandtesting.notes.api.TokenManager;
import com.expandtesting.notes.models.NotePayload;
import com.expandtesting.notes.utils.PerformanceUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNoteApiTest {

    @Test
    public void testCreateNoteSuccessfully() {

        String token = TokenManager.getToken();

        NotePayload payload = new NotePayload(
                "API Note " + System.currentTimeMillis(),
                "Created through Rest Assured",
                "Work"
        );

        Response response = NotesApi.createNote(token, payload);

        response.then().statusCode(200);

        PerformanceUtil.assertResponseTime(
                response.getTime(),
                "POST /notes"
        );

        Assert.assertNotNull(
                response.jsonPath().getString("data.id"),
                "Created note ID should not be null"
        );

        Assert.assertTrue(
                response.jsonPath()
                        .getString("message")
                        .toLowerCase()
                        .contains("success"),
                "Note should be created successfully"
        );
    }
}
