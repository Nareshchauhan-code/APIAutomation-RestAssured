package com.restassured;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExtractValuefromResponseByJsonPath {
    @Test
    public void testRestAssured() {

       Response response =given().baseUri("https://api.getpostman.com").header("X-Api-Key", "PMAK-63590fbcd307b504237e1884-daff29b7948d5c5f5f8256c0cd232e7dca").
                when().get("/workspaces").
                then().assertThat().statusCode(200).extract().response();

        JsonPath jsonPath = new JsonPath(response.asString());

        System.out.println(jsonPath.getString("workspaces[0].name"));
    }
}
