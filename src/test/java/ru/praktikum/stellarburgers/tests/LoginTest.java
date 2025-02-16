package ru.praktikum.stellarburgers.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.praktikum.stellarburgers.api.UserClient;
import ru.praktikum.stellarburgers.pages.LoginPage;

public class LoginTest extends BaseTest {

    private String email;
    private String password;

    @Before
    public void setUp() {
        super.setUp();

        String name = "User" + RandomStringUtils.randomAlphanumeric(5);
        email = "user" + RandomStringUtils.randomAlphanumeric(5) + "@gmail.com";
        password = RandomStringUtils.randomAlphanumeric(10);

        UserClient userClient = new UserClient();
        userClient.register(email, password, name);
    }

    @Test
    public void testLoginThroughMainPageButton() {
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.login(email, password);
        assertTrue("После успешного логина должна открыться главная страница", mainPage.isDisplayed());
    }

    @Test
    public void testLoginThroughPersonalAccountButton() {
        mainPage.open();
        mainPage.clickPersonalAccount();
        loginPage.login(email, password);
        assertTrue("После успешного логина должна открыться главная страница", mainPage.isDisplayed());
    }

    @Test
    public void testLoginThroughRegisterForm() {
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();

        String name = "TestUser";
        String regEmail = "testuser" + RandomStringUtils.randomAlphanumeric(5) + "@gmail.com";
        String regPassword = RandomStringUtils.randomAlphanumeric(10);

        registerPage.register(name, regEmail, regPassword);

        // Пересоздаем страницу логина
        loginPage = new LoginPage(driver);
        loginPage.login(regEmail, regPassword);

        assertTrue("После успешного логина должна открыться главная страница", mainPage.isDisplayed());
    }
}