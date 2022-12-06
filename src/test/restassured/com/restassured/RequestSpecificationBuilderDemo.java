package com.restassured;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RequestSpecificationBuilderDemo {
    RequestSpecification requestSpecification;

    @BeforeClass
    public void requestSpecificationReuse() {

//        requestSpecification = with().
//                baseUri("https://api.getpostman.com").
//                header("X-Api-Key", "PMAK-63590fbcd307b504237e1884-daff29b7948d5c5f5f8256c0cd232e7dca").log().all();

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.getpostman.com");
        requestSpecBuilder.addHeader("X-Api-Key", "PMAK-63590fbcd307b504237e1884-daff29b7948d5c5f5f8256c0cd232e7dca");

        requestSpecification = requestSpecBuilder.build();
    }

    @Test
    public void testRestAssured1() {
        Response response = given().spec(requestSpecification).get("/workspaces").
                then().log().headers().extract().response();

        assertThat(response.statusCode(), is(equalTo(200)));

    }

    @Test
    public void testRestAssured2() {

        Response response = given().spec(requestSpecification).get("/workspaces").
                then().log().headers().extract().response();

        assertThat(response.statusCode(), is(equalTo(200)));

    }

    @Test
    public void testRestAssured3() {
        Response response = given().spec(requestSpecification).get("/workspaces").
                then().log().headers().extract().response();

        assertThat(response.statusCode(), is(equalTo(200)));
    }

    @Test
    public void testRestAssured4() {


        Response response = given().spec(requestSpecification).get("/workspaces").
                then().log().headers().extract().response();

        assertThat(response.statusCode(), is(equalTo(200)));

    }
}
