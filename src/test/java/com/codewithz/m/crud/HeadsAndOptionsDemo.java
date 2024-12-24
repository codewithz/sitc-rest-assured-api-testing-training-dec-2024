package com.codewithz.m.crud;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class HeadsAndOptionsDemo {

    static final  String BASE_URL="https://api.github.com/";

    @Test
    void headTest(){
        RestAssured
                .head(BASE_URL)
                .then()
                .statusCode(200)
                .body(Matchers.emptyOrNullString());

    }

    @Test
    void optionsTest(){
        RestAssured
                .options(BASE_URL)
                .then()
                .statusCode(204)
                .header(
                        "access-control-allow-methods",
                        Matchers.equalTo("GET, POST, PATCH, PUT, DELETE")
                        )
                .body(Matchers.emptyOrNullString());
    }
}
