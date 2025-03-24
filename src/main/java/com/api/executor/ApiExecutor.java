package com.api.executor;

import static io.restassured.RestAssured.given;

public class ApiExecutor {
    public static io.restassured.response.Response sendPostRequest(String endpoint, String payload) {
        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
}
