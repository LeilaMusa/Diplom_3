package ru.praktikum.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.stellarburgers.config.WebDriverConfig;
import ru.praktikum.stellarburgers.pages.LoginPage;
import ru.praktikum.stellarburgers.pages.MainPage;
import ru.praktikum.stellarburgers.pages.RegisterPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private MainPage mainPage;
    private String email;
    private String password;
    private String name;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        driver = WebDriverConfig.createDriver();
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        mainPage = new MainPage(driver);

        // Генерируем тестовые данные
        email = faker.internet().emailAddress();
        password = faker.internet().password(6, 10);
        name = faker.name().fullName();
    }

    @After
    public void tearDown() {
        if (userToken != null) {
            userClient.deleteUser(userToken);
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Вход через кнопку 'Войти в аккаунт' на главной")
    @Description("Проверка входа через кнопку на главной странице")
    public void loginFromMainPageTest() {
        createUser(email, password, name);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.loginWithRedirect(email, password);

        assertTrue("После входа не произошел переход на главную страницу",
                driver.getCurrentUrl().equals("https://stellarburgers.nomoreparties.site/"));
    }

    @Test
    @DisplayName("Вход через личный кабинет")
    @Description("Проверка входа через кнопку личного кабинета")
    public void loginFromPersonalAccountTest() {
        createUser(email, password, name);

        mainPage.open();
        mainPage.clickPersonalAccount();
        loginPage.loginWithRedirect(email, password);

        assertTrue("После входа не произошел переход на главную страницу",
                driver.getCurrentUrl().equals("https://stellarburgers.nomoreparties.site/"));
    }

    @Test
    @DisplayName("Ошибка при неверном пароле")
    @Description("Проверка, что пользователь остается на странице входа при вводе неверного пароля")
    public void loginWithWrongPasswordTest() {
        createUser(email, password, name);

        mainPage.open();
        mainPage.clickLoginButton();

        // Выполняем вход с некорректным паролем
        loginPage.login(email, "wrong");

        // Проверяем сообщение об ошибке
        assertEquals("Некорректный пароль", loginPage.getErrorText());
    }
}