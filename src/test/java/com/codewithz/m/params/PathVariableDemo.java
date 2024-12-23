package com.codewithz.m.params;


import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PathVariableDemo {
static final String BASE_URL="https://api.github.com/repos";

static final String USER="codewithz";
static final String REPO="node-project-for-postman";

@Test
void withoutPathParam(){
    RestAssured
            .get(
                    "https://api.github.com/repos/{user}/{repo}",
                    USER, REPO)
            .then()
            .statusCode(200)
            .body("id", Matchers.equalTo(906873502));
}

    @Test
    void withPathParam(){
        RestAssured
                .given()
                .pathParam("user",USER)
                .pathParam("repo",REPO)
                .get("https://api.github.com/repos/{user}/{repo}")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(906873502));
    }


}
