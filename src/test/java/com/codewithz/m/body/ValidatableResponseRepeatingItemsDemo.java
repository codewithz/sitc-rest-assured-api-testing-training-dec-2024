package com.codewithz.m.body;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class ValidatableResponseRepeatingItemsDemo {

    static final String USERS_URL="https://reqres.in/api/users";

    @Test
    void testRepeatingItems(){
        RestAssured
                .given()
                .param("page","1")
                .get(USERS_URL)
                .then()
                .body("data.id[0]",equalTo(1))
                .body("data.id[1]",equalTo(2))
                .body("data.first_name[2]",equalTo("Emma"))
//                .body("data.first_name",hasItem("Zartab"));
                .body("data.first_name",hasItem("George"))
                .body("data.first_name",hasItems("Janet","Tracey"))
                .body("data.first_name",hasItem(endsWith("ma")));

    }

}
