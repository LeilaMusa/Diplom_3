package ru.praktikum.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api";

    @Step("Создание пользователя через API")
    public Response createUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post(BASE_URL + "/auth/register");
    }

    @Step("Удаление пользователя через API")
    public void deleteUser(String token) {
        given()
                .header("Authorization", token)
                .delete(BASE_URL + "/auth/user")
                .then()
                .statusCode(202);
    }

    @Step("Логин пользователя через API")
    public Response loginUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post(BASE_URL + "/auth/login");
    }
}