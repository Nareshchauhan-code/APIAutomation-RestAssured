package com.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequestDemo {
    @Test
    public void testRestAssured() {

        given().baseUri("").
                when().
                then();

    }
}
