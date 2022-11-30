package com.restassured;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class ResponseSpecificationBuilderDemo {
    RequestSpecification requestSpecification;
   ResponseSpecification responseSpecification;

    @BeforeClass
    public void requestSpecificationReuse() {

        requestSpecification = with().
                baseUri("https://api.getpostman.com").
                header("X-Api-Key", "PMAK-63590fbcd307b504237e1884-daff29b7948d5c5f5f8256c0cd232e7dca");

        //responseSpecification= RestAssured.expect().statusCode(200);

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);

        responseSpecification=responseSpecBuilder.build();
    }

    @Test
    public void testRestAssured1() {


        given().spec(requestSpecification).
                when().get("/workspaces").
                then().spec(responseSpecification);

    }

    @Test
    public void testRestAssured2() {

        given().spec(requestSpecification).
                when().get("/workspaces").
                then().spec(responseSpecification);

    }

    @Test
    public void testRestAssured3() {

        given().spec(requestSpecification).
                when().get("/workspaces").
                then().spec(responseSpecification);

    }

    @Test
    public void testRestAssured4() {


        given(requestSpecification).
                when().get("/workspaces").
                then().spec(responseSpecification);

    }
}
