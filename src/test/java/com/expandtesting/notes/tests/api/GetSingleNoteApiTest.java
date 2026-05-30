package com.expandtesting.notes.tests.api;

import com.expandtesting.notes.api.NotesApi;
import com.expandtesting.notes.api.TokenManager;
import com.expandtesting.notes.models.NotePayload;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleNoteApiTest {

    @Test
    public void testGetSingleNoteSuccessfully() {

        String token = TokenManager.getToken();

        NotePayload payload = new NotePayload(
                "Single Note " + System.currentTimeMillis(),
                "Get single note validation",
                "Home"
        );

        Response createResponse = NotesApi.createNote(token, payload);
        createResponse.then().statusCode(200);

        String noteId = createResponse.jsonPath().getString("data.id");

        Response getResponse = NotesApi.getNoteById(token, noteId);
        getResponse.then().statusCode(200);

        Assert.assertEquals(
                getResponse.jsonPath().getString("data.id"),
                noteId,
                "Correct note should be returned"
        );
    }
}
