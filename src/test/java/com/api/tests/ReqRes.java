package com.api.tests;

import com.api.base.ReqresService;
import com.api.models.response.Data;
import com.api.models.response.ReqresResponse;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

public class ReqRes {

    //    https://reqres.in/api/users?page=2
    @Test
    public void verifyResponse() {
        ReqresService service = new ReqresService();
        Response response = service.getResponse();
    ReqresResponse reqresResponse = response.as(ReqresResponse.class);
        List<Data> data = reqresResponse.data();
        List<String> firstnameList = data.stream().map(Data::first_name).collect(Collectors.toList());

        System.out.println("---------------------");
        System.out.println(firstnameList);
        System.out.println("---------------------");
        Assert.assertTrue(firstnameList.contains("George"));

//
        //        List<String> list = response.jsonPath().getList("data.first_name");

    }

    @Test
    public void verifyMock() {

        WireMockServer server = new WireMockServer(8181);

        server.start();
        //Below line is needed if you call WireMock.stubFor()
        //Not needed when you use server.stubFor()
//        WireMock.configureFor("localhost",8181);

        ResponseDefinitionBuilder responseDefinitionBuilder = WireMock.aResponse().withBody(
                """
                         {"Firstname":"Sivashankar",
                         "Lastname":"K"
                        }
                        """
        ).withStatus(200);



        server.stubFor(WireMock.get("/personalData").willReturn(responseDefinitionBuilder));

        RestAssured.given().get("http://localhost:8181/personalData").prettyPrint();

        server.stop();

    }


}
