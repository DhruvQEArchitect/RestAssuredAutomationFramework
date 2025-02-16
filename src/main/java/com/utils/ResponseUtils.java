package com.utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseUtils {

    public static Response getResponse() {
        RestAssured.baseURI = Helper.getEndpoint();
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation();
        requestSpecification.headers("content-type", "application/json");
        return requestSpecification.request(Method.GET);
    }

    public static Response postResponse(Object body) {
        RestAssured.baseURI = Helper.getEndpoint();
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation();
        requestSpecification.headers("content-type", "application/json");
        return requestSpecification.body(body).request(Method.POST);
    }
}
