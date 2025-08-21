package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginApiTest {

    @Test(description = "Verify if Login is working")
    public void Logintest()
    {

        LoginRequest loginRequest=new LoginRequest("sivahk94@gmail.com","TechWithMe94#");

        AuthService authService = new AuthService();
        //Java object to Json
        Response response = authService.login(loginRequest);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
        //Json to Java object
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println("Token::->"+loginResponse.token());
        System.out.println("Email::->"+loginResponse.email());
//        System.out.println("Email::->"+loginResponse.getEmail());
        Assert.assertEquals(loginResponse.email(),"sivahk94@gmail.com");



    }

    @Test(description = "Verify if Login is working")
    public void Logintest2  ()
    {

//        baseURI="";

        Response response = given().baseUri("http://64.227.160.186:8080")
                .header("Content-Type", "application/json")
                .body("""
                        {
                        "username":"sivahk94@gmail.com",
                        "password":"TechWithMe94#"
                        }
                        """)
                .post("/api/auth/login");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(),200);


    }

    //RequestSpecification is interface
    //FilterableRequestSpecification is subInterface
    //RequestSpecificationImpl is class which implements above one

    // staticimport  improves readabilty
}
