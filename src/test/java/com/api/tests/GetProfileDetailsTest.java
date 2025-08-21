package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetProfileDetailsTest {

    @Test

    public void getprofileDetails() {

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("sivahk94@gmail.com", "TechWithMe94#"));

        LoginResponse loginResponse = response.as(LoginResponse.class);
        String token = loginResponse.token();

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(token);
//        response.prettyPrint();
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        String email = userProfileResponse.email();
        System.out.println(email);


    }
}
