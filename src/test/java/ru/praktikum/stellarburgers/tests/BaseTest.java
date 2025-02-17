package ru.praktikum.stellarburgers.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.stellarburgers.pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected ProfilePage profilePage;
    protected ConstructorPage constructorPage;
    protected RegisterPage registerPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        constructorPage = new ConstructorPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}