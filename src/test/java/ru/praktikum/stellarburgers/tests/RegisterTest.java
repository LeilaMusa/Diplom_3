package ru.praktikum.stellarburgers.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.praktikum.stellarburgers.pages.MainPage;
import ru.praktikum.stellarburgers.pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void testRegistrationWithShortPassword() {
        // Генерация случайных данных для регистрации
        String name = "User" + RandomStringUtils.randomAlphanumeric(5);
        String email = "user" + RandomStringUtils.randomAlphanumeric(5) + "@gmail.com";
        String shortPassword = "12345"; // Короткий пароль (меньше 6 символов)

        // Открываем страницу регистрации
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();

        // Регистрация пользователя с коротким паролем
        registerPage.register(name, email, shortPassword);

        // Проверяем, что появилось сообщение об ошибке
        String errorMessage = registerPage.getPasswordError();
        assertEquals("Сообщение об ошибке должно быть 'Некорректный пароль'", "Некорректный пароль", errorMessage);
    }
}