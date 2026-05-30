package com.expandtesting.notes.tests.api;

import com.expandtesting.notes.api.NotesApi;
import com.expandtesting.notes.api.TokenManager;
import com.expandtesting.notes.models.NotePayload;
import com.expandtesting.notes.utils.PerformanceUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateNoteApiTest {

    @Test(enabled = false)
    public void testUpdateNoteSuccessfully() {

        String token = TokenManager.getToken();

        NotePayload createPayload = new NotePayload(
                "Old Note " + System.currentTimeMillis(),
                "Old Description",
                "Home"
        );

        Response createResponse =
                NotesApi.createNote(token, createPayload);

        createResponse.then().statusCode(200);

        String noteId =
                createResponse.jsonPath().getString("data.id");

        Assert.assertNotNull(
                noteId,
                "Created note ID should not be null"
        );

        NotePayload updatePayload = new NotePayload(
                "Updated Note",
                "Updated Description",
                "Home"
        );

        Response updateResponse =
                NotesApi.updateNote(token, noteId, updatePayload);

        updateResponse.then().statusCode(200);

        PerformanceUtil.assertResponseTime(
                updateResponse.getTime(),
                "PUT /notes/" + noteId
        );

        Assert.assertTrue(
                updateResponse.jsonPath()
                        .getString("message")
                        .toLowerCase()
                        .contains("success"),
                "Note should be updated successfully"
        );
    }
}