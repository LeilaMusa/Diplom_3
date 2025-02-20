package ru.praktikum.stellarburgers.tests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.praktikum.stellarburgers.api.User;
import ru.praktikum.stellarburgers.api.UserClient;

public class BaseTest {
    protected WebDriver driver;
    protected UserClient userClient;
    protected String userToken;
    protected final Faker faker = new Faker();

    @Before
    public void setUp() {
        userClient = new UserClient();
    }

    @After
    public void tearDown() {
        if (userToken != null) {
            userClient.deleteUser(userToken);
        }
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Error while closing WebDriver: " + e.getMessage());
            }
        }
    }

    protected void createUser(String email, String password, String name) {
        User user = new User(email, password, name);
        Response response = userClient.createUser(user);
        userToken = response.then()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }
}