package ru.yandex.test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.page.*;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;

    private String email = "12345678@ya.ru";
    private String password = "12345678@ya.ru";

    @Before
    public void setup() {
/*        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\WebDriver\\bin\\chromedriver.exe");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site");
*/
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void checkLoginBySignInButton() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objConstructorPage.clickSignInButton();

        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickSignInButton();

        objConstructorPage.clickAccountButton();
        objAccountPage.waitForLoadLogoutButton();
        assertTrue(objAccountPage.isLogoutButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void checkLoginByAccountButton() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objConstructorPage.clickAccountButton();

        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickSignInButton();

        objConstructorPage.clickAccountButton();
        objAccountPage.waitForLoadLogoutButton();
        assertTrue(objAccountPage.isLogoutButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void checkLoginFromRegisterPage() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objConstructorPage.clickSignInButton();
        objConstructorPage.clickRegisterButton();
        objRegisterPage.clickSignInButton();

        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickSignInButton();

        objConstructorPage.clickAccountButton();
        objAccountPage.waitForLoadLogoutButton();
        assertTrue(objAccountPage.isLogoutButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void checkLoginByRestorePasswordButton() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        RestorePasswordPage objRestorePasswordPage = new RestorePasswordPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objConstructorPage.clickSignInButton();
        objLoginPage.clickRestorePasswordButton();
        objRestorePasswordPage.clickSignInButton();

        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickSignInButton();

        objConstructorPage.clickAccountButton();
        objAccountPage.waitForLoadLogoutButton();
        assertTrue(objAccountPage.isLogoutButtonVisible());
    }
}
