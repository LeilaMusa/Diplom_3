package ru.praktikum.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.stellarburgers.config.WebDriverConfig;
import ru.praktikum.stellarburgers.pages.LoginPage;
import ru.praktikum.stellarburgers.pages.MainPage;
import ru.praktikum.stellarburgers.pages.ProfilePage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ProfileTest extends BaseTest {
    private final String browser;
    private MainPage mainPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private String email;
    private String password;
    private String name;

    public ProfileTest(String browser) {
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
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        email = faker.internet().emailAddress();
        password = faker.internet().password(6, 10);
        name = faker.name().fullName();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода в личный кабинет после авторизации")
    public void profileAccessTest() {
        createUser(email, password, name);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.login(email, password);
        mainPage.clickPersonalAccount();

        assertTrue("Профиль не отображается", profilePage.isProfileDisplayed());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверка выхода из аккаунта через личный кабинет")
    public void logoutTest() {
        createUser(email, password, name);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.login(email, password);
        mainPage.clickPersonalAccount();
        profilePage.logout();

        // Ожидаем, что кнопка "Войти" отобразится на странице логина
        assertTrue("Кнопка входа не отображается после выхода из аккаунта",
                loginPage.isLoginButtonDisplayed());
    }
}