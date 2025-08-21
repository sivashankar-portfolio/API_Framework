package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthService extends BaseService{

    private static final String BASE_PATH="/api/auth";
   /* public Response login(String payload)
    {

        return postRequest(payload,BASE_PATH+"/login");
    }*/

    public Response login(LoginRequest payload)
    {

        return postRequest(payload,BASE_PATH+"/login");
    }

    public Response signup(SignUpRequest payload)
    {

        return postRequest(payload,"/signup");
    }

    public Response forgotPassword(String email)
    {
        Map<String, String> map = new HashMap<>();
        map.put("email",email);
        return postRequest(map,"/forgot-password");
    }
}
