package com.HelperCode;

import com.api.executor.ApiExecutor;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class PetStoreHelper {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    public static String loadRequestTemplate(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static Response createPet(int id, String name, String status) throws IOException {
        String filePath = "/Users/animesh.c/IdeaProjects/api-test-framework/src/Resource/CreatePet.json";
        String requestBody = loadRequestTemplate(filePath)
                .replace("{id}", String.valueOf(id))
                .replace("{name}", name)
                .replace("{status}", status);

        return ApiExecutor.sendPostRequest(BASE_URL + "/pet", requestBody);
    }
}