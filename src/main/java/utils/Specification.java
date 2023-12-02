package utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.*;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Specification {

    public static final RequestSpecification REQ_SPEC =
                        new RequestSpecBuilder()
                                .addFilter(new AllureRestAssured())
                                .setContentType(ContentType.JSON)
                                .setRelaxedHTTPSValidation()
                                .setBaseUri("https://stellarburgers.nomoreparties.site/api/")
                                .setBasePath("auth/")
                                .log(LogDetail.ALL)
                                .build();



    public static final ResponseSpecification RES_SPEC =
                        new ResponseSpecBuilder()
                                .log(LogDetail.ALL)
                                .build();
}


