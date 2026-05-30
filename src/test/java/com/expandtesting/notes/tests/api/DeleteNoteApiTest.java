package com.expandtesting.notes.tests.api;

import com.expandtesting.notes.api.NotesApi;
import com.expandtesting.notes.api.TokenManager;
import com.expandtesting.notes.models.NotePayload;
import com.expandtesting.notes.utils.PerformanceUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNoteApiTest {

    @Test
    public void testDeleteNoteSuccessfully() {

        String token = TokenManager.getToken();

        NotePayload payload = new NotePayload(
                "API Delete Note " + System.currentTimeMillis(),
                "Temporary note for delete test",
                "Personal"
        );

        Response createResponse = NotesApi.createNote(token, payload);
        createResponse.then().statusCode(200);

        String noteId = createResponse.jsonPath().getString("data.id");

        Assert.assertNotNull(
                noteId,
                "Created note ID should not be null"
        );

        Response deleteResponse =
                NotesApi.deleteNote(token, noteId);

        deleteResponse.then().statusCode(200);

        PerformanceUtil.assertResponseTime(
                deleteResponse.getTime(),
                "DELETE /notes"
        );

        Assert.assertTrue(
                deleteResponse.jsonPath()
                        .getString("message")
                        .toLowerCase()
                        .contains("success"),
                "Note should be deleted successfully"
        );
    }
}
