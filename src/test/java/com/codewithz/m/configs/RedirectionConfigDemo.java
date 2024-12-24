package com.codewithz.m.configs;

import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RedirectionConfigDemo {
    static final String BASE_URL="https://api.github.com/";

    @Test
    void maxRedirectsTest(){

        RestAssured.config=RestAssured.config()
                        .redirect(RedirectConfig
                                .redirectConfig()
                                .followRedirects(false)
                        );
        RestAssured
                .get(BASE_URL+"repos/twitter/bootstrap")
                .then()
                .statusCode(Matchers.equalTo(200));


    }
}
