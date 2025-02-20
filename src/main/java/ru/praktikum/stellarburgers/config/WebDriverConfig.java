package ru.praktikum.stellarburgers.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class WebDriverConfig {
    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        String browser = System.getProperty("browser", "chrome"); // По умолчанию chrome

        if ("yandex".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "drivers/yandexdriver.exe");
            options.setBinary("C:\\Users\\User\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        }

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-browser-side-navigation");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
}