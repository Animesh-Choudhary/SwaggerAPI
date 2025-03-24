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
    public static io.restassured.response. Response sendPutRequest(String endpoint, String payload) {
        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public static io.restassured.response. Response sendPatchRequest(String endpoint, String payload) {
        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .patch(endpoint)
                .then()
                .extract()
                .response();
    }

    public static io.restassured.response. Response sendDeleteRequest(String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
}
