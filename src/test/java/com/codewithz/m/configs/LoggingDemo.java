package com.codewithz.m.configs;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.Test;

public class LoggingDemo {

    static final String BASE_URL="https://jsonplaceholder.typicode.com/posts";


    @Test
    void logTest(){
        RestAssured
                .given()
                .log().all()
//                OR
                .log().headers()
                .log().body()

                .when()
                .get(BASE_URL)
                .then()
                .statusCode(205)
                    //no conditions
                    .log().headers()
                    //with condition
                    .log().ifValidationFails(LogDetail.ALL);

    }
}
