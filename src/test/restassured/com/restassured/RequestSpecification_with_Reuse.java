package com.restassured;


import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class RequestSpecification_with_Reuse {
    RequestSpecification requestSpecification;

    @BeforeClass
    public void requestSpecificationReuse() {

        requestSpecification = with().
                baseUri("https://api.getpostman.com").
                header("X-Api-Key", "PMAK-63590fbcd307b504237e1884-daff29b7948d5c5f5f8256c0cd232e7dca");

    }

    @Test
    public void testRestAssured1() {


        given().spec(requestSpecification).
                when().get("/workspaces").
                then().log().headers().assertThat().statusCode(200);

    }

    @Test
    public void testRestAssured2() {

        given().spec(requestSpecification).
                when().get("/workspaces").
                then().log().ifError().assertThat().statusCode(200);

    }

    @Test
    public void testRestAssured3() {

        given().spec(requestSpecification).
                when().get("/workspaces").
                then().log().ifValidationFails().assertThat().statusCode(200);

    }

    @Test
    public void testRestAssured4() {


        given(requestSpecification).
                when().get("/workspaces").
                then().log().all().assertThat().statusCode(200);

    }
}
