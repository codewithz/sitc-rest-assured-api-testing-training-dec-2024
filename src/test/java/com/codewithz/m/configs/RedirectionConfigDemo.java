package com.codewithz.m.configs;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RedirectionConfigDemo {
    static final String BASE_URL="https://api.github.com/";

    @Test
    void maxRedirectsTest(){
        RestAssured
                .get(BASE_URL+"repos/twitter/bootstrap")
                .then()
                .statusCode(Matchers.equalTo(200));


    }
}
