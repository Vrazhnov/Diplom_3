package ru.yandex.test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.config.Config;
import ru.yandex.page.AccountPage;
import ru.yandex.page.ConstructorPage;
import ru.yandex.page.LoginPage;

import static org.junit.Assert.assertTrue;

public class LogoutTest {

    private WebDriver driver;
    private String name = "12345678@ya.ru";

    @Before
    public void setup() {
        driver = Config.get();
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void checkLoginBySignInButton() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objConstructorPage.clickSignInButton();

        objLoginPage.setEmail(name);
        objLoginPage.setPassword(name);
        objLoginPage.clickSignInButton();

        objConstructorPage.clickAccountButton();
        objAccountPage.waitForLoadLogoutButton();
        objAccountPage.clickLogoutButton();

        //проверяем, что мы оказались на странице входа и видим кнопку "Войти"
        objLoginPage.waitForLoadSignInButtonButton();
        //пытаемся перейти в "Личный кабинет" и проверяем, что мы действительно не залогинены и продолжаем видеть кнопку "Войти"
        objConstructorPage.clickAccountButton();
        assertTrue(objLoginPage.isSignInButtonVisible());
    }
}
