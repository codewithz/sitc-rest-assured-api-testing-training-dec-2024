package com.codewithz.m.body;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReqResFilterExample {

    public static void main(String[] args) {
        // 1. Send a GET request to the ReqRes API
        Response response = RestAssured
                .given()
                .get("https://reqres.in/api/users?page=1");

        // 2. Extract the 'data' array as a List of Maps
        List<Map<String, Object>> allUsers = response.jsonPath().getList("data");

        // 3. Filter where 'id' > 6
        List<Map<String, Object>> filteredUsers = allUsers.stream()
                .filter(userMap -> {
                    // Extract 'id' from the map and cast to Integer
                    Integer userId = (Integer) userMap.get("id");
                    return userId > 2;
                })
                .collect(Collectors.toList());

        // 4. Print out the filtered results
        System.out.println("All Users: " + allUsers);
        System.out.println("Filtered (id > 2): " + filteredUsers);
    }
}

