package com.codewithz.m.codeorganization.ratelimit;

import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseRateLimit {

    @BeforeMethod
    void setup(){
        RestAssured.baseURI="https://api.github.com";
        RestAssured.basePath="/rate_limit";
    }

    @AfterMethod
    void teardown(){
        RestAssured.baseURI=RestAssured.DEFAULT_URI;
        RestAssured.basePath=RestAssured.DEFAULT_PATH;
    }
}
