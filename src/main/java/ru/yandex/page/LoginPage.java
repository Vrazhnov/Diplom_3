package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    //Кнопка "Зарегистрироваться"
    private By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    //Кнопка "Войти"
    private By signInButton = By.xpath(".//*[text()='Войти']");
    //Кнопка "Восстановить пароль"
    private By restorePasswordButton = By.xpath("//*[text()='Восстановить пароль']");
    //Поле "Email"
    private By emailField = By.xpath(".//*[text()='Email']/../input");
    //Поле "Пароль"
    private By passwordField = By.xpath(".//*[text()='Пароль']/../input");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод нажатия на кнопку "Зарегистрироваться"
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    //метод нажатия на кнопку "Войти"
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    //метод для проверки видимости кнопки "Войти"
    public boolean isSignInButtonVisible() {
        return driver.findElement(signInButton).isDisplayed();
    }

    //метод для ожидания кнопки "Войти"
    public void waitForLoadSignInButtonButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(signInButton));
    }

    //метод нажатия на кнопку "Восстановить пароль"
    public void clickRestorePasswordButton() {
        driver.findElement(restorePasswordButton).click();
    }

    //метод ввода значения в поле "Email"
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    //метод ввода значения в поле "Пароль"
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
}