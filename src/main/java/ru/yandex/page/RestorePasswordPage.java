package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RestorePasswordPage {

    private WebDriver driver;
    //Кнопка "Войти"
    private By signInButton = By.xpath("//*[text()='Войти']");

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод нажатия на кнопку "Войти"
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
}
