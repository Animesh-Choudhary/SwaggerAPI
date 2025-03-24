package com.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Converts a Map to a JSON string.
     */
    public static String getJsonPayload(Map<String, Object> data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert map to JSON", e);
        }
    }

    /**
     * Reads a JSON template from a file.
     */
    public static String loadJsonTemplate(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON template from: " + filePath, e);
        }
    }

    /**
     * Replaces placeholders in a JSON template with actual values.
     */
    public static String replacePlaceholders(String jsonTemplate, Map<String, Object> values) {
        if (jsonTemplate == null || jsonTemplate.isEmpty()) {
            throw new IllegalArgumentException("JSON template cannot be null or empty");
        }
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Replacement values cannot be null or empty");
        }

        for (Map.Entry<String, Object> entry : values.entrySet()) {
            String placeholder = "\\{" + entry.getKey() + "\\}"; // Matches {key}
            jsonTemplate = jsonTemplate.replaceAll(placeholder, entry.getValue().toString());
        }
        return jsonTemplate;
    }
}
