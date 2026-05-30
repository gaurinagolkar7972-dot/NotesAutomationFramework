package com.expandtesting.notes.tests.api;

import com.expandtesting.notes.api.NotesApi;
import com.expandtesting.notes.models.NotePayload;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNoteWithoutTokenTest {

    @Test
    public void testCreateNoteWithoutToken() {

        NotePayload payload = new NotePayload(
                "Unauthorized Note",
                "Trying to create note without token",
                "Home"
        );

        Response response =
                NotesApi.createNote("", payload);

        Assert.assertTrue(
                response.statusCode() == 401
                        || response.statusCode() == 403,
                "Create note without token should fail"
        );
    }
}
