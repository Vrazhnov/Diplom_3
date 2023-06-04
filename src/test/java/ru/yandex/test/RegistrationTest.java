package ru.yandex.test;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.config.Config;
import ru.yandex.page.AccountPage;
import ru.yandex.page.ConstructorPage;
import ru.yandex.page.LoginPage;
import ru.yandex.page.RegisterPage;

import static org.junit.Assert.assertTrue;


public class RegistrationTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = Config.get();
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Ошибку для некорректного пароля")
    public void checkIncorrectPassword() throws InterruptedException {
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.setName(RandomStringUtils.randomAlphabetic(3, 8));
        objRegisterPage.setEmail(RandomStringUtils.randomAlphabetic(6, 8) + "@ya.ru");
        objRegisterPage.setPassword(RandomStringUtils.randomAlphabetic(1, 5));
        objRegisterPage.clickRegisterButton();
        // делаем проверку, что сообщение о некорректном пароле видно
        assertTrue(objRegisterPage.isIncorrectPasswordErrorVisible());
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void checkRegistration() throws InterruptedException {
        RegisterPage objRegisterPage = new RegisterPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);
        String name = RandomStringUtils.randomAlphabetic(3, 8);
        String email = RandomStringUtils.randomAlphabetic(6, 8) + "@ya.ru";
        String password = RandomStringUtils.randomAlphabetic(6, 10);

        objRegisterPage.setName(name);
        objRegisterPage.setEmail(email);
        objRegisterPage.setPassword(password);

        objRegisterPage.clickRegisterButton();
        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickSignInButton();

        objConstructorPage.clickAccountButton();

        objAccountPage.waitForLoadLogoutButton();
        assertTrue(objAccountPage.isLogoutButtonVisible());
    }
}
