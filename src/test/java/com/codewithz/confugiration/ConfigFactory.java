package com.codewithz.confugiration;

import io.restassured.config.FailureConfig;
import io.restassured.config.LogConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.listener.ResponseValidationFailureListener;

public class ConfigFactory {

    public static RestAssuredConfig getDefaultConfig(){

        ResponseValidationFailureListener responseValidationFailureListener
                =new MyResponseValidationFailureListener();
        return
                RestAssuredConfig.config()
                        .logConfig(
                                LogConfig
                                        .logConfig()
                                        .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)

                        )
                        .redirect(
                                RedirectConfig
                                        .redirectConfig()
                                        .maxRedirects(1)
                        )
                        .failureConfig(
                                FailureConfig
                                        .failureConfig()
                                        .failureListeners(responseValidationFailureListener)
                        );

    }
}
