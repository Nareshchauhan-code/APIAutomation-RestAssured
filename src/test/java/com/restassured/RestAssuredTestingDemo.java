package com.restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTestingDemo {
    @Test
    public void testRestAssured() {

        given().when().then();

    }
}
