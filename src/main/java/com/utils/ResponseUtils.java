package com.utils;

import com.reporting.Reporting;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.apache.commons.lang3.StringUtils;

public class ResponseUtils {

    static Response response;
    static QueryableRequestSpecification queryableRequestSpecification;
    static RequestSpecification requestSpecification;

    private static RequestSpecification getRequestSpecification() {
        RestAssured.baseURI = Helper.getEndpoint();
        requestSpecification = RestAssured.given().relaxedHTTPSValidation();
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
        queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        Reporting.logInfo("Request base uri: " + queryableRequestSpecification.getBaseUri());
        Reporting.logInfo("Body of the request is: ");
        Reporting.logJsonData(queryableRequestSpecification.getBody());
        Reporting.logInfo("Request method is: " + queryableRequestSpecification.getMethod());
    }

    public static Response getResponse(String path) {

        requestSpecification = getRequestSpecification();
        if (StringUtils.isBlank(path)) {
            response = requestSpecification.get(((RequestSpecificationImpl) requestSpecification).getBaseUri());
        } else {
            response = requestSpecification.get(((RequestSpecificationImpl) requestSpecification).getBaseUri()).path(path);
        }
        requestInputParams(requestSpecification);
        responseLogger(response);
        return response;
    }

    public static Response postResponse(Object body) {
        queryableRequestSpecification = SpecificationQuerier.query(getRequestSpecification());
        requestSpecification = getRequestSpecification();
        Response response = requestSpecification.body(body).post(((RequestSpecificationImpl) requestSpecification).getBaseUri());
        requestInputParams(requestSpecification);
        responseLogger(response);
        return response;
    }
}
