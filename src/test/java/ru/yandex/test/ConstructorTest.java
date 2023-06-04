package ru.yandex.test;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.config.Config;
import ru.yandex.page.ConstructorPage;

import static org.hamcrest.CoreMatchers.is;

public class ConstructorTest {


    private WebDriver driver;

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
    @DisplayName("Переход к разделу «Соусы»")
    public void checkSaucesButtonSelected() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickSaucesButton();
        MatcherAssert.assertThat(objConstructorPage.getNameSelectedIngredientButton(), is("Соусы"));
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void checkToppingsButtonSelected() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickToppingsButton();
        MatcherAssert.assertThat(objConstructorPage.getNameSelectedIngredientButton(), is("Начинки"));
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void checkBunsButtonSelected() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        //Т.к. по умолчанию на странице уже выбрана кнопка "Булки", то, для проверки перехода, сначала переключаемся на "Соусы", чтобы с них переключится на "Булки"
        objConstructorPage.clickSaucesButton();
        objConstructorPage.clickBunsButton();
        MatcherAssert.assertThat(objConstructorPage.getNameSelectedIngredientButton(), is("Булки"));
    }

}
