package com.moviesdb.api.automation.utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIFunctions {

    public static Response response;

    static RequestSpecification reqSpec = new RequestSpecBuilder()
            .setBaseUri(GenericFunctions.getConfigProperties().getProperty("baseURI"))
            .addHeader("Content-Type", "application/json;charset=utf-8")
            .addHeader("Authorization",
                    "Bearer " + GenericFunctions.getConfigProperties().getProperty("writeAccessToken"))
            .addQueryParam("api_key", GenericFunctions.getConfigProperties().getProperty("apiKey")).build().log().all();

    public static Response getRequest(String url) {
        response = RestAssured.given(reqSpec).get(url);
        return response;
    }

    public static <T> Response postRequest(T Object, String url) {
        response = RestAssured.given(reqSpec).body(Object).post(url);
        return response;
    }

    public static <T> Response updateRequest(T Object, String url) {
        response = RestAssured.given(reqSpec).body(Object).put(url);
        return response;
    }

    public static <T> Response deleteRequest(String url) {
        response = RestAssured.given(reqSpec).delete(url);
        return response;
    }

    public static <T> Response deleteRequest(T Object, String url) {
        response = RestAssured.given(reqSpec).body(Object).delete(url);
        return response;
    }

}
