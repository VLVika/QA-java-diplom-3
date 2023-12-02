package praktikum.ru.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static utils.Specification.REQ_SPEC;
import static utils.Specification.RES_SPEC;

public class DeleteUser {

    @Step("Удаляет пользователя")
    public static Response deleteUser(String token){
        Response response = given()
                .spec(REQ_SPEC)
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .delete("user")
                .then()
                .spec(RES_SPEC)
                .body("success", is(true))
                .extract().response();
        return response;

    }
}
