package com.api.listeners;

import io.qameta.allure.Attachment;
import io.restassured.response.Response;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListener implements ITestListener {

    @Attachment(value = "API Response", type = "application/json")
    public static String attachResponse(String response) {
        return response;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object response = result.getAttribute("response");
        if (response instanceof Response) {
            attachResponse(((Response) response).getBody().asPrettyString());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object response = result.getAttribute("response");
        if (response instanceof Response) {
            attachResponse(((Response) response).getBody().asPrettyString());
        }
    }
}
