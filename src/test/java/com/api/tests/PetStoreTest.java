package com.api.tests;

import BaseTest.BaseTest;
import com.api.executor.ApiExecutor;
import com.api.listeners.AllureTestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

@Listeners(AllureTestListener.class)  // Attach listener globally
public class PetStoreTest extends BaseTest {
    private final String BASE_URL = "https://petstore.swagger.io/v2";

    @Test
    @Description("Pet Creation..")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreatePet() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", 1234);
        payload.put("name", "Bulldog");
        payload.put("status", "available");

        Response response = ApiExecutor.sendPostRequest(BASE_URL + "/pet", String.valueOf(payload));
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "Animesh", "Name does not match!");

        // Set response as an attribute for the listener to capture
        org.testng.Reporter.getCurrentTestResult().setAttribute("response", response);
    }
}
