package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UpdateProfileTest {


    @Test
    public void updateProfileTest()
    {


        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("sivahk94@gmail.com", "TechWithMe94#"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        String token = loginResponse.token();

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        userProfileManagementService.getProfile(token);

        ProfileRequest profileRequest = new ProfileRequest("Sarvesh","S","sivahk94@gmail.com","8526620207");
        System.out.println("-------------------------------------------");
        userProfileManagementService.updateProfile(profileRequest,token);


    }
}
