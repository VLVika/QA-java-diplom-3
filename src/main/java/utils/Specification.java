package utils;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static utils.GlobalVariables.BASE_URL;
import static utils.GlobalVariables.PATH_AUT;

public class Specification {

    public static final RequestSpecification REQ_SPEC =
                        new RequestSpecBuilder()
                                .addFilter(new AllureRestAssured())
                                .setContentType(ContentType.JSON)
                                .setRelaxedHTTPSValidation()
                                .setBaseUri(BASE_URL)
                                .setBasePath(PATH_AUT)
                                .log(LogDetail.ALL)
                                .build();



    public static final ResponseSpecification RES_SPEC =
                        new ResponseSpecBuilder()
                                .log(LogDetail.ALL)
                                .build();
}


