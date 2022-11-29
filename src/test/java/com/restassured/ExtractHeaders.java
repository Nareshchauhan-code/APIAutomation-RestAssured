package com.restassured;


import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExtractHeaders {
    @Test
    public void testRestAssured() {

        Headers headers =given().baseUri("https://api.getpostman.com").header("X-Api-Key", "PMAK-63590fbcd307b504237e1884-daff29b7948d5c5f5f8256c0cd232e7dca").
                when().get("/workspaces").
                then().assertThat().statusCode(200).extract().headers();

        System.out.println(headers);

    }
}
