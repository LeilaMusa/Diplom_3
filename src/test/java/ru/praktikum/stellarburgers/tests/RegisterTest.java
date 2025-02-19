package ru.praktikum.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.stellarburgers.api.User;
import ru.praktikum.stellarburgers.api.UserClient;
import ru.praktikum.stellarburgers.config.WebDriverConfig;
import ru.praktikum.stellarburgers.pages.RegisterPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegisterTest extends BaseTest {
    private final String browser;
    private RegisterPage registerPage;
    private UserClient userClient;
    private String email;
    private String password;
    private String name;

    public RegisterTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Browser: {0}")
    public static Object[] getBrowsers() {
        return new Object[]{"chrome", "yandex"};
    }

    @Before
    @Override
    public void setUp() {
        super.setUp();
        driver = WebDriverConfig.createDriver(browser);
        registerPage = new RegisterPage(driver);
        userClient = new UserClient();

        email = faker.internet().emailAddress();
        password = faker.internet().password(6, 10);
        name = faker.name().fullName();
    }

    @Test
    @DisplayName("Успешная регистрация через API")
    @Description("Проверка успешной регистрации нового пользователя через API")
    public void successfulRegistrationViaApiTest() {
        User user = new User(email, password, name);
        Response response = userClient.createUser(user);

        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().jsonPath().getBoolean("success"));
    }

    @Test
    @DisplayName("Успешная регистрация через UI")
    @Description("Проверка успешной регистрации нового пользователя через UI")
    public void successfulRegistrationTest() {
        registerPage.open();
        registerPage.register(name, email, password);

        assertTrue("Регистрация не была успешной",
                driver.getCurrentUrl().contains("/login"));
    }

    @Test
    @DisplayName("Ошибка при некорректном пароле")
    @Description("Проверка ошибки при попытке регистрации с паролем менее 6 символов")
    public void invalidPasswordRegistrationTest() {
        String shortPassword = "12345"; // Пароль менее 6 символов

        registerPage.open();
        registerPage.setName(name);
        registerPage.setEmail(email);
        registerPage.setPassword(shortPassword);
        registerPage.clickRegisterButton();

        assertEquals("Некорректный пароль", registerPage.getErrorText());
    }
}