package ru.praktikum.stellarburgers.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserClient {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api";

    public Response register(String email, String password, String name) {
        return RestAssured.given()
                .header("Content-type", "application/json")
                .body(String.format("{\"email\": \"%s\", \"password\": \"%s\", \"name\": \"%s\"}", email, password, name))
                .post(BASE_URL + "/auth/register");
    }

    public Response login(String email, String password) {
        return RestAssured.given()
                .header("Content-type", "application/json")
                .body(String.format("{\"email\":\"%s\", \"password\":\"%s\"}", email, password))
                .post(BASE_URL + "/auth/login");
    }

    public Response deleteUser(String accessToken) {
        return RestAssured.given()
                .header("Authorization", accessToken)
                .delete(BASE_URL + "/auth/user");
    }
}