package com.codewithz.m.codeorganization;

import com.codewithz.confugiration.ConfigFactory;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TopBaseTestClass {

    @BeforeSuite
    void suiteSetup(){
        RestAssured.config= ConfigFactory.getDefaultConfig();
    }

    @BeforeMethod
    void setup(){
        RestAssured.baseURI="https://api.github.com";
    }
    @AfterMethod
    void teardown(){
        RestAssured.baseURI=RestAssured.DEFAULT_URI;
    }
}
