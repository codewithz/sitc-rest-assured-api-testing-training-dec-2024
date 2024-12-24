package com.codewithz.m.codeorganization.badendpoint;

import com.codewithz.confugiration.ResponseSpecs;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class BadEndpointTest {

    static final String BAD_URL="https://api.github.com/non/existing/url";


    @Test
    void testWithSpecOne(){
        RestAssured
                .get(BAD_URL)
                .then()
                .spec(ResponseSpecs.badEndPointSpec())
                .body("message", Matchers.equalTo("Not Found"));
    }

     @Test
    void testWithSpecTwo(){
        RestAssured
                .get(BAD_URL)
                .then()
                .spec(ResponseSpecs.badEndPointSpec())
                .body("documentation_url", Matchers.equalTo("https://docs.github.com/rest"));
    }


}
