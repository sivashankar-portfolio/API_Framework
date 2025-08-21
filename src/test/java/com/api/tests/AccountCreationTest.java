package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {


    @Test
    public void accountCreationTest() {

//        SignUpRequest.Builder builder = new SignUpRequest.Builder()
//                .username("sivashankar_2")
//                .password("TechWithMe94#")
//                .email("mailtosiva74@gmail.com")
//                .firstName("Sivashankar")
//                .lastName("K")
//                .mobileNumber("8888888888");
//                  SignUpRequest signUpRequest = builder.build();

        SignUpRequest signUpRequest = SignUpRequest.builder()
                .username("shk694come")
                .password("TechWithMe94#")
                .email("siva34hw4k94@gmail.com")
                .firstName("Johssn")
                .lastName("Doe")
                .mobileNumber("9878543210")
                .build();


        AuthService authService = new AuthService();
        Response response = authService.signup(signUpRequest);

        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");

    }
}
