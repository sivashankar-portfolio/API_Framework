package com.api.base;

import com.api.filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BaseService {

    //    private static final String BASE_URI = "https://reqres.in/";
    private static final String BASE_URI = "http://64.227.160.186:8080";
    private RequestSpecification requestSpecification = given();

    public BaseService() {
        requestSpecification.baseUri(BASE_URI).contentType(ContentType.JSON);
    }

    static {
        RestAssured.filters(new LoggingFilter());
    }

    protected void setAuthToken(String token) {
        requestSpecification.auth().oauth2(token);
    }

    /*protected Response postRequest(String payload,String endpoint)
    {
        return requestSpecification.body(payload).post(endpoint);
    }*/

    protected Response postRequest(Object payload, String endpoint) {

        return requestSpecification.body(payload).post(endpoint);
    }

    protected Response getRequest(String endpoint) {
        return requestSpecification.get(endpoint);
//        return requestSpecification.queryParam("page",2).get(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint) {
        return requestSpecification.body(payload).put(endpoint);
    }

    /*protected Response postRequest(String endpoint, Object... payload)
    {
        return requestSpecification.body(payload).post(endpoint);
    }*/

}


//When BASE_URI was "" got java.lang.IllegalStateException target Host is null
//when requestSpecification was not initlaized , got Nullpointer excception