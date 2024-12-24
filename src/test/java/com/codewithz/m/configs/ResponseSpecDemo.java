package com.codewithz.m.configs;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResponseSpecDemo {

    static final  String BASE_URL="https://api.github.com/";

    @BeforeClass
    void setUp(){

        System.out.println("---------- in Setup ---------");
        RestAssured.requestSpecification=
                new RequestSpecBuilder()
                        .setBaseUri(BASE_URL)
                        .build();

        RestAssured.responseSpecification=
                new ResponseSpecBuilder()
                        .expectStatusCode(404)
                        .expectContentType(ContentType.JSON)
                        .build();
    }
    @AfterClass
    void cleanUp(){
        System.out.println("---------- in CleanUp ---------");
        RestAssured.responseSpecification=null;
    }

    @Test
    void testWithResponseSpec(){
        RestAssured
                .get(BASE_URL+"non/existing/url");
    }

}
