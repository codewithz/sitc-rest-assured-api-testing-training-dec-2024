package com.codewithz.m.configs;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RequestSpecDemo {

    static final  String BASE_URL="https://api.github.com";

    static RequestSpecification requestSpec=
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URL)
                    .build();

//    Alternative
    @BeforeSuite
    void setup(){
        RestAssured.requestSpecification=
                new RequestSpecBuilder()
                        .setBaseUri(BASE_URL)
                        .build();
    }

    @Test
    void testUsingLocalRequestSpec(){
        RestAssured
                .given()
                    .spec(requestSpec)
                .when()
                    .get()
                .then()
                .statusCode(200);
    }

}
