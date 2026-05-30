package com.expandtesting.notes.api;

import com.expandtesting.notes.models.NotePayload;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class NotesApi {

    private NotesApi() {
    }

    public static Response getNotes(String token) {
        return given()
                .spec(BaseApi.requestSpec())
                .header("x-auth-token", token)
                .when()
                .get("/notes");
    }

    public static Response createNote(String token, NotePayload payload) {
        return given()
                .spec(BaseApi.requestSpec())
                .header("x-auth-token", token)
                .body(payload)
                .when()
                .post("/notes");
    }

    public static Response deleteNote(String token, String noteId) {
        return given()
                .spec(BaseApi.requestSpec())
                .header("x-auth-token", token)
                .when()
                .delete("/notes/" + noteId);
    }

    public static Response updateNote(String token, String noteId, NotePayload payload) {
        return given()
                .spec(BaseApi.requestSpec())
                .header("x-auth-token", token)
                .body(payload)
                .when()
                .put("/notes/" + noteId);
    }

    public static Response getNoteById(String token, String noteId) {
        return given()
                .spec(BaseApi.requestSpec())
                .header("x-auth-token", token)
                .when()
                .get("/notes/" + noteId);
    }
}
