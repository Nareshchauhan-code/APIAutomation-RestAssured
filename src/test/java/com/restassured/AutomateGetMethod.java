package com.restassured;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AutomateGetMethod {
    @Test
    public void testRestAssured() {

        given().baseUri("https://api.getpostman.com").header("X-Api-Key", "PMAK-63590fbcd307b504237e1884-daff29b7948d5c5f5f8256c0cd232e7dca").
                when().get("/workspaces").
                then().log().all().assertThat().statusCode(200);

    }
}
