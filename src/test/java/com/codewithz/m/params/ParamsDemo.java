package com.codewithz.m.params;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ParamsDemo {

    static final String BASE_URL="https://api.github.com/search/repositories";

    @Test
    void withoutParams(){
        RestAssured
                .get(BASE_URL+"?q=java")
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void withoutParams2(){
        RestAssured
                .get(BASE_URL+"?q=java&per_page=5")
                .prettyPeek()
                .then()
                .statusCode(200);
    }
    @Test
    void withParam(){
        RestAssured
                .given()
                .param("q","java")
                .param("per_page","5")
                .get(BASE_URL)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}
