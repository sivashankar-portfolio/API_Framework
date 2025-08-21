package com.api.base;

import io.restassured.response.Response;

public class ReqresService extends BaseService{

    public Response getResponse()
    {

        return getRequest("api/users");
    }
}
