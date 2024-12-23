package com.codewithz.m.header;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicResponseDemo {

    static final String BASE_URL="https://api.github.com";

    @Test
    void convenienceMethods(){
       Response response= RestAssured.get(BASE_URL);
        Assert.assertEquals(response.getStatusCode(),
                200);
        Assert.assertEquals(response.getContentType(),
                "application/json; charset=utf-8");

    }

    @Test
    void genericHeaders(){
        Response response=RestAssured.get(BASE_URL);
        Assert.assertEquals(response.getHeader("server"),
                "github.com");
        String rateLimitHeader=response.getHeader("x-ratelimit-limit");
        Assert.assertEquals(rateLimitHeader,
                "60");

//        OR

        Assert.assertEquals(Integer.parseInt(rateLimitHeader),60);



    }

}
