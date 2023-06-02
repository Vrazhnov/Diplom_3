package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;
    //Поле "Имя"
    private By nameField = By.xpath(".//*[text()='Имя']/../input");
    //Поле "Email"
    private By emailField = By.xpath("//*[text()='Email']/../input");
    //Поле "Пароль"
    private By passwordField = By.xpath("//*[text()='Пароль']/../input");
    //Кнопка "Зарегистрироваться"
    private By registerButton = By.xpath("//*[text()='Зарегистрироваться']");
    //Ошибка с текстом "Некорректный пароль"
    private By incorrectPasswordError = By.xpath("//*[text()='Некорректный пароль']");
    //Кнопка "Войти"
    private By signInButton = By.xpath("//*[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод ввода значения в поле "Имя"
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //метод ввода значения в поле "Email"
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    //метод ввода значения в поле "Пароль"
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    //метод нажатия на кнопку "Зарегистрироваться"
    public void clickRegisterButton() throws InterruptedException {
        driver.findElement(registerButton).click();
        Thread.sleep(500);
    }

    //метод для проверки видимости ошибки с текстом "Некорректный пароль"
    public boolean isIncorrectPasswordErrorVisible() {
        return driver.findElement(incorrectPasswordError).isDisplayed();
    }

    //метод нажатия на кнопку "Войти"
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
}
