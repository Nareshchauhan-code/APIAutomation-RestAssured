package com.restassuredautomation;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AutomatePostMethodAsObject {


    @BeforeClass
    public void requestSpecificationReuse() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.getpostman.com").
                addHeader("X-Api-Key", "PMAK-63590fbcd307b504237e1884-daff29b7948d5c5f5f8256c0cd232e7dca").
                setContentType(ContentType.JSON);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200).expectContentType(ContentType.JSON).log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void testRestAssured1() {

        HashMap<String, Object> manObject = new HashMap<>();

        HashMap<String, String> nextedObject = new HashMap<>();
        nextedObject.put("name", "MyObjectWorkSpaces");
        nextedObject.put("type", "personal");
        nextedObject.put("discription", "Resassured");

        manObject.put("workspace", nextedObject);


        given().body(manObject).
                when().post("/workspaces").then().assertThat().
                body("workspace.name", equalTo("MyObjectWorkSpaces"));


    }


}
