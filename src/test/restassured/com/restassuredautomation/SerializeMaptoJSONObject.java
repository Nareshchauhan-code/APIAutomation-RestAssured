package com.restassuredautomation;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SerializeMaptoJSONObject {


    @BeforeClass
    public void requestSpecificationReuse() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.getpostman.com").
                addHeader("X-Api-Key", "PMAK-63590fbcd307b504237e1884-daff29b7948d5c5f5f8256c0cd232e7dca").
                setContentType(ContentType.JSON);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200).expectContentType(ContentType.JSON).log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void testRestAssured1() throws JsonProcessingException {

        HashMap<String, Object> manObject = new HashMap<>();

        HashMap<String, String> nextedObject = new HashMap<>();
        nextedObject.put("name", "NareshChauhan");
        nextedObject.put("type", "personal");
        nextedObject.put("discription", "Resassured");

        manObject.put("workspace", nextedObject);

        ObjectMapper objectMapper = new ObjectMapper();
        String manObjectStr = objectMapper.writeValueAsString(manObject);

        given().body(manObjectStr).
                when().post("/workspaces").then().assertThat().
                body("workspace.name", equalTo("NareshChauhan"));


    }


}
