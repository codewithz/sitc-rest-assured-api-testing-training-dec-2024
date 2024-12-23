package com.codewithz.m.body;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.Map;

public class BasicResponseBodyDemo {

    static final String LIMIT_URL="https://api.github.com/rate_limit";

    @Test
    void jsomMap(){
        Response response= RestAssured.get(LIMIT_URL);

        ResponseBody<?> body=response.body();
        JsonPath jPath=body.jsonPath();

        JsonPath jPath2=response.body().jsonPath();

        Map<String,String> fullJson=jPath2.get();
        System.out.println("Full:"+fullJson);

        Map<String,String> subMap1=jPath2.get("resources");
        System.out.println("resources:"+subMap1);

        Map<String,String> subMap2=jPath2.get("rate");
        System.out.println("rate:"+subMap2);

        Map<String,String> subMap3=jPath2.get("resources.graphql");
        System.out.println("resources.graphql:"+subMap3);

        int v1= jPath2.get("resources.core.limit");
        System.out.println("Limit:"+v1);

        int v2= jPath2.get("resources.graphql.remaining");
        System.out.println("Remaining:"+v2);

    }
}
