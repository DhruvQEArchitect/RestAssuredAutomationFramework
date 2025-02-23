package com.utils;

import com.reporting.Reporting;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class ResponseUtils {

    private static RequestSpecification getRequestSpecification() {
        RestAssured.baseURI = Helper.getEndpoint();
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation();
        requestSpecification.headers("content-type", "application/json");
        return requestSpecification;
    }

    private static void responseLogger(Response response) {
        Reporting.logInfo("Response code is: " + response.getStatusCode());
        Reporting.logInfo("Response headers are: " + response.headers().asList().toString());
        Reporting.logInfo("Response of the request is: ");
        Reporting.logJsonData(response.asPrettyString());
    }

    private static void requestInputParams(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        Reporting.logInfo("Request base uri: " + queryableRequestSpecification.getBaseUri());
        Reporting.logInfo("Body of the request is: ");
        Reporting.logJsonData(queryableRequestSpecification.getBody());
        Reporting.logInfo("Request method is: " + queryableRequestSpecification.getMethod());
    }

    public static Response getResponse() {
        RequestSpecification requestSpecification = getRequestSpecification();
        Response response = getRequestSpecification().get();
        requestInputParams(requestSpecification);
        responseLogger(response);
        return response;
    }

    public static Response postResponse(Object body) {
        RequestSpecification requestSpecification = getRequestSpecification();
        Response response = getRequestSpecification().body(body).post();
        requestInputParams(requestSpecification);
        responseLogger(response);
        return response;
    }
}
