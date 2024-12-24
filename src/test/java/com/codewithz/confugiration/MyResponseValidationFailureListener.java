package com.codewithz.confugiration;

import io.restassured.listener.ResponseValidationFailureListener;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MyResponseValidationFailureListener implements ResponseValidationFailureListener {

    @Override
    public void onFailure(RequestSpecification requestSpecification, ResponseSpecification responseSpecification, Response response) {
        System.out.printf("Response Status was %s and body contained %s",
                response.getStatusCode(),response.body().asPrettyString());
    }
}
