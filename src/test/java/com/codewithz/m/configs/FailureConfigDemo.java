package com.codewithz.m.configs;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class FailureConfigDemo {

    static final String BASE_URL="https://api.github.com/";


    @Test
    void failingTestTest(){
        ResponseValidationFailureListener
                responseValidationFailureListener= new MyResponseValidationFailureListener();
//                =(requestSpecification, responseSpecification, response)
//                -> System.out.printf("Response Status was %s and body contained %w",
//                    response.getStatusCode(),response.body().asPrettyString());
        RestAssured.config= RestAssured.config()
                        .failureConfig(
                                FailureConfig
                                        .failureConfig()
                                        .failureListeners(responseValidationFailureListener));

        RestAssured
                .get(BASE_URL+"users/codewithz")
                .then()
                .body("some.path", Matchers.equalTo("a thing"));
    }
}
