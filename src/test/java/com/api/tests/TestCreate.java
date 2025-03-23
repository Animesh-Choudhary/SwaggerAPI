package com.api.tests;

import BaseTest.BaseTest;
import com.HelperCode.PetStoreHelper;
import com.api.listeners.AllureTestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

@Listeners(AllureTestListener.class)  // Attach listener globally
public class TestCreate extends BaseTest {

    @Test
    @Description("Pet Creation..")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreatePet() throws IOException {
        Response response = PetStoreHelper.createPet(1234, "Animesh", "available");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "Animesh", "Name does not match!");
        Assert.assertEquals(response.jsonPath().getString("status"), "available", "status does not match!");

        // Set response as an attribute for the listener to capture
        org.testng.Reporter.getCurrentTestResult().setAttribute("response", response);
    }
}
