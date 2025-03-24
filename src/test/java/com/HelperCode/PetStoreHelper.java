package com.HelperCode;

import com.api.executor.ApiExecutor;
import com.api.utils.JsonUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class PetStoreHelper {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    public static Response createPet(int id, String name, String status) {
        String filePath = "/Users/animesh.c/IdeaProjects/api-test-framework/src/Resource/CreatePet.json";

        // Load JSON template from file
        String jsonTemplate = JsonUtils.loadJsonTemplate(filePath);

        // Creating a map to store pet details
        Map<String, Object> petDetails = new HashMap<>();
        petDetails.put("id", id);
        petDetails.put("name", name);
        petDetails.put("status", status);

        // Convert map to JSON string using JsonUtils
        String requestBody = JsonUtils.getJsonPayload(petDetails);

        // Sending POST request
        return ApiExecutor.sendPostRequest(BASE_URL + "/pet", requestBody);
    }
}