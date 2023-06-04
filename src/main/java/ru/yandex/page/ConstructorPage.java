package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorPage {

    //Кнопка "Личный Кабинет"
    private final By accountButton = By.xpath("//*[text()='Личный Кабинет']");
    private WebDriver driver;
    //Кнопка "Войти в аккаунт"
    private By signInButton = By.xpath("//*[text()='Войти в аккаунт']");
    //Кнопка "Конструктор"
    private By constructorButton = By.xpath("//*[text()='Конструктор']");
    //Stellar Burgers Logo
    private By stellarBurgersLogo = By.className("AppHeader_header__logo__2D0X2");
    //Вкладка "Зарегистрироваться"
    private By registerButton = By.xpath("//*[text()='Зарегистрироваться']");
    //Кнопка "Булки"
    private By bunsButton = By.xpath("//*[text()='Булки']");
    //Кнопка "Соусы"
    private By saucesButton = By.xpath("//*[text()='Соусы']");
    //Кнопка "Начинки"
    private By toppingsButton = By.xpath("//*[text()='Начинки']");
    //Кнопка ингридиента, которая была нажата
    private By selectedIngredientButton = By.xpath("//div[contains(@class,'tab_tab_type_current__2BEPc')]");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод нажатия на кнопку "Войти в аккаунт"
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void waitForLoadSignInButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(signInButton));
    }

    //метод нажатия на кнопку "Личный Кабинет"
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    //метод нажатия на кнопку "Конструктор"
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    //метод нажатия на Stellar Burgers Logo
    public void clickStellarBurgersLogo() {
        driver.findElement(stellarBurgersLogo).click();
    }

    //метод нажатия на кнопку "Зарегистрироваться"
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    //метод нажатия на кнопку "Булки"
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }

    //метод нажатия на кнопку "Соусы"
    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }

    //метод нажатия на кнопку "Начинки"
    public void clickToppingsButton() {
        driver.findElement(toppingsButton).click();
    }

    //метод для проверки видимости вкладки "Булки"
    public boolean isSaucesButtonVisible() {
        return driver.findElement(saucesButton).isDisplayed();
    }

    public String getNameSelectedIngredientButton() {
        return driver.findElement(selectedIngredientButton).getText();
    }
}