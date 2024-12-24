package com.codewithz.m.crud;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PostPutDeleteDemo {

        static final String BASE_URL = "https://api.github.com/user/repos";
        static final String TOKEN=" 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";

        @Test(description = "Create a Repo")
        void postTest(){
            RestAssured
                    .given()
                        .header("Authorization", "token "+TOKEN)
                        .body("{\"name\":\"delete-me-cwz\"}")  //"{\"name\":\"delete-me-cwz\"}"
                    .when()
                         .post(BASE_URL)
                    .then()
                        .statusCode(201);
        }

        @Test(description = "Patching a Repo")
        void patchTest(){
            RestAssured
                    .given()
                        .header("Authorization", "token "+TOKEN)
                        .body("{\"name\":\"delete-me-cwz-updated\"}")
                    .when()
                        .patch("https://api.github.com/repos/codewithz/delete-me-cwz")
                    .then()
                        .statusCode(200);

        }

        @Test(description = "Delete a Repo")
        void deleteTest(){
            RestAssured
                    .given()
                       .header("Authorization", "token "+TOKEN)
                    .when()
                        .delete("https://api.github.com/repos/codewithz/delete-me-cwz-updated")
                    .then()
                        .statusCode(204);
        }


}
