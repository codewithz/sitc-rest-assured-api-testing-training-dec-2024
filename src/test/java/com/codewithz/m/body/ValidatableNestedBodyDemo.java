package com.codewithz.m.body;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class ValidatableNestedBodyDemo {

//    RAte Limit URL

//

//    {
//        "resources": {
//        "core": {
//            "limit": 60,
//                    "remaining": 55,
//                    "reset": 1734947413,
//                    "used": 5,
//                    "resource": "core"
//        },
//        "graphql": {
//            "limit": 0,
//                    "remaining": 0,
//                    "reset": 1734948582,
//                    "used": 0,
//                    "resource": "graphql"
//        },
//        "integration_manifest": {
//            "limit": 5000,
//                    "remaining": 5000,
//                    "reset": 1734948582,
//                    "used": 0,
//                    "resource": "integration_manifest"
//        },
//        "search": {
//            "limit": 10,
//                    "remaining": 10,
//                    "reset": 1734945042,
//                    "used": 0,
//                    "resource": "search"
//        }
//    },
//        "rate": {
//        "limit": 60,
//                "remaining": 55,
//                "reset": 1734947413,
//                "used": 5,
//                "resource": "core"
//    }
//    }

    static final String LIMIT_URL="https://api.github.com/rate_limit";
    //   resources.core  --> limit =60, remaining <60, reset !=null
    //    resources.search -- limit=10, remaining <=10
//    resources.graphql.limit == 10
    @Test
    void nestedBodyValidation(){
        RestAssured.get(LIMIT_URL)
                .then()
                .rootPath("resources.core")
                    .body("limit", equalTo(60))
                    .body("remaining",lessThanOrEqualTo(60))
                    .body("reset",notNullValue())
                .rootPath("resources.search")
                    .body("limit",equalTo(10))
                    .body("remaining",lessThanOrEqualTo(10))
                .noRootPath()
                .body("resources.graphql.limit",equalTo(0));
    }


}
