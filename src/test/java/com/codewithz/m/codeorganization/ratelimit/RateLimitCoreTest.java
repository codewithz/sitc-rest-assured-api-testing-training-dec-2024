package com.codewithz.m.codeorganization.ratelimit;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RateLimitCoreTest extends BaseRateLimit {

    @Test
    void resourcesCoreDefaultValuesAreCorrect(){
        RestAssured
                    .get()
                .then()
                    .rootPath("resources.core")
                    .body("limit", Matchers.equalTo(6))
                    .body("remaining", Matchers.lessThanOrEqualTo(60));
        }

}
