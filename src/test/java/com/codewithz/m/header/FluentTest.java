package com.codewithz.m.header;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class FluentTest {

    @Test
    void fluentTest() {
        RestAssured
                .given()    //Given
                .get("https://api.github.com") //When
                .then()  //Then
                .statusCode(200)
                .contentType("application/json")
                .header("x-ratelimit-limit",
                        "60");
    }
}
