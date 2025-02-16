package com.utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseUtils {

    private static RequestSpecification getRequestSpecification() {
        RestAssured.baseURI = Helper.getEndpoint();
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation();
        requestSpecification.headers("content-type", "application/json");
        return requestSpecification;
    }

    public static Response getResponse() {
        return getRequestSpecification().request(Method.GET);
    }

    public static Response postResponse(Object body) {
        return getRequestSpecification().body(body).request(Method.GET);
    }
}
