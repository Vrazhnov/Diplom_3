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

public class TransitionTest {

    private WebDriver driver;
    private String email = "12345678@ya.ru";
    private String password = "12345678@ya.ru";

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
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на «Конструктор»")
    public void checkTransitionByConstructorButton() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);

        objConstructorPage.clickSignInButton();

        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickSignInButton();
        //переход по кнопке "Личный кабинет" проверяется в рамках выполнения шагов данного и многих других тестов
        objConstructorPage.clickAccountButton();
        objAccountPage.waitForLoadLogoutButton();

        objConstructorPage.clickConstructorButton();
        assertTrue(objConstructorPage.isSaucesButtonVisible());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void checkTransitionByLogoButton() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objConstructorPage.clickSignInButton();

        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickSignInButton();
        //переход по кнопке "Личный кабинет" проверяется в рамках выполнения шагов данного и многих других тестов
        objConstructorPage.clickAccountButton();
        objAccountPage.waitForLoadLogoutButton();

        objConstructorPage.clickStellarBurgersLogo();
        assertTrue(objConstructorPage.isSaucesButtonVisible());
    }
}
