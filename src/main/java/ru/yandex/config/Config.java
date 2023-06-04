package ru.yandex.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Config {
    public static WebDriver get() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return setupChrome();
        }

        switch (browser) {
            case "chrome":
                return setupChrome();
            case "yandex":
            default:
                return setupYandex();
        }
    }


    private static WebDriver setupChrome() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }

    private static WebDriver setupYandex() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }

}