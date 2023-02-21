package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.PageManager;


public class HomePage extends BasePage{
    @Step("Проврка прогрузилась ли главная страничка")
    public HomePage checkMainMenu() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitStabilityPage(5000,250);
        listener.getScreenshot();
        Assert.assertTrue(waitUtilElementToBeVisible(findElementByXpath(elementLocators.FIELD_SEARCH_FOR_CHECK_OPEN)).isDisplayed(), "Гланая старничка не открылась");
        return this;
    }
    @Step("Поиск продукта")
    public HomePage searchProduct(String product) {
        waitStabilityPage(5000,250);
        findElementByXpath(elementLocators.SEARCH).sendKeys(product);
        listener.getScreenshot();
        return this;
    }
    @Step("Нажатие поиска")
    public CatalogPage clickSearch() {
        waitUtilElementToBeClickable(findElementByXpath(elementLocators.FIND_BUTTON)).click();
        return PageManager.getPageManager().getCatalogPage();
    }


}
