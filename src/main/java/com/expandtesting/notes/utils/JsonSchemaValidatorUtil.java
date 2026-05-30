package com.expandtesting.notes.utils;

import io.restassured.response.Response;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class JsonSchemaValidatorUtil {

    private JsonSchemaValidatorUtil() {
    }

    public static void validate(Response response, String schemaPath) {
        response.then().body(
                matchesJsonSchema(
                        new File("src/test/resources/" + schemaPath)
                )
        );
    }
}
