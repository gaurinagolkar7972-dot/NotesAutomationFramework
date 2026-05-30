package com.expandtesting.notes.api;

import com.expandtesting.notes.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    private BaseApi() {
    }

    public static RequestSpecification requestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(
                        ConfigReader.getProperty("apiBaseUrl")
                )
                .setContentType("application/json")
                .build()
                .relaxedHTTPSValidation();
    }
}
