package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

    private WebDriver driver;
    //Кнопка "Выход"
    private By logoutButton = By.xpath("//*[text()='Выход']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadLogoutButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }

    //метод нажатия на кнопку "Выход"
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public boolean isLogoutButtonVisible() {
        return driver.findElement(logoutButton).isDisplayed();
    }

    public void waitForInvisibilityLoadingAnimation() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("Modal_modal__loading__3534A")));
    }

}
