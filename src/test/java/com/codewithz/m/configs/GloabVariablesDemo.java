package com.codewithz.m.configs;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GloabVariablesDemo {

    @BeforeSuite
    void setup(){
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="api/users";
    }

    @Test
    void testOneUsingGlobalConstants(){
        RestAssured
                .get()
                .then()
                .body("data.id[0]", Matchers.equalTo(1));
    }

    @Test
    void testTwoUsingGlobalConstants(){
        RestAssured
                .get()
                .then()
                .body("data.first_name[2]", Matchers.equalTo("Emma"));
    }


}
