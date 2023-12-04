package praktikum.ru.api.steps;

import io.qameta.allure.Step;
import praktikum.ru.api.pojo.CreateUserPojoRq;

import java.net.HttpURLConnection;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static utils.Specification.REQ_SPEC;
import static utils.Specification.RES_SPEC;

public class CreateUser {

    @Step("Создаёт пользователя")
    public String getTokenNewUser(CreateUserPojoRq request){
        return given()
                .spec(REQ_SPEC)
                .when()
                .body(request)
                .post("register")
                .then()
                .spec(RES_SPEC)
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("success", is(true))
                .extract()
                .jsonPath().getString("accessToken");

    }

}
