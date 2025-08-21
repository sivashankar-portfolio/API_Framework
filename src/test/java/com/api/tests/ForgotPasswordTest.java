package com.api.tests;

import com.api.base.AuthService;

import io.restassured.response.Response;

import org.testng.annotations.Test;

public class ForgotPasswordTest {


    @Test
    public void forgotPswdtest() {

        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("sivahk95@gmail.com");
        response.prettyPrint();
        System.out.println(response.getStatusCode());


//        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");

    }
}
