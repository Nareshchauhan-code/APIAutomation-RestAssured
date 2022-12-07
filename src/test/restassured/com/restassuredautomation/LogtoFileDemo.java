package com.restassuredautomation;


import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;

public class LogtoFileDemo {
    @Test
    public void testRestAssured() throws FileNotFoundException {

        PrintStream FileOutPutStream = new PrintStream(new File("restAssured.log"));

        given().baseUri("https://api.getpostman.com").
                filter(new RequestLoggingFilter(FileOutPutStream)).filter(new ResponseLoggingFilter(FileOutPutStream)).
                header("X-Api-Key", "PMAK-63590fbcd307b504237e1884-daff29b7948d5c5f5f8256c0cd232e7dca").
                when().get("/workspaces").
                then().assertThat().statusCode(200);

    }
}
