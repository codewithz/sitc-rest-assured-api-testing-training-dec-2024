package com.codewithz.m.body;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ValidatableResponseBodyDemo {

    static final String BASE_URL="https://api.github.com/";

    @Test
    void matcherExample(){
        RestAssured.get(BASE_URL)
                .then()
                //For checking the vlaue against a key
                .body("current_user_url",
                        Matchers.equalTo(BASE_URL+"user"))
                //to check if a key exist in response
                .body(Matchers.containsString("feeds_url"))
                .body(
                        Matchers.containsString("repository_url")
                        , Matchers.containsString("organization_url"));
    }
}
