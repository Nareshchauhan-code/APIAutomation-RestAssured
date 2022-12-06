package com.restassured;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

public class LoggingMethods {
    @Test
    public void testRestAssured() {

        given().baseUri("https://api.getpostman.com").header("X-Api-Key", "PMAK-63590fbcd307b504237e1884-daff29b7948d5c5f5f8256c0cd232e7dca").log().all().
                when().get("/workspaces").
                then().log().all().assertThat().statusCode(200).body("workspaces.name", contains("My Workspace", "Team Workspace", "RestAssured"));

    }
}
