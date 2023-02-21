package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.utils.Item;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class CatalogPage extends BasePage{
    @Step("Взять список продуктов после поиска")
    public CatalogPage takeListOfProducts() {
        waitStabilityPage(5000, 250);
        listener.getScreenshot();
        scrollToElementJs(findElementByXpath(elementLocators.SCROLL_TO_BOTTOM));
        waitUtilElementToBeVisible(findElementByXpath(elementLocators.SCROLL_TO_BOTTOM));

        List<WebElement> listName = findElementsByXpath(elementLocators.NAME_OF_PRODUCTS);
        List<WebElement> listPrice = findElementsByXpath(elementLocators.PRICE_OF_PRODUCTS);

        for (int i = 0; i < Math.min(listName.size(), listPrice.size()); i++) {
            Item.getProducts().setName(listName.get(i).getText().toLowerCase());
            Item.getProducts().setPrice(listPrice.get(i).getText());
            products.add(Item.getProducts());
        }
        return this;
    }

    @Step("Проверка искомого продукта из списка")
    public CatalogPage checkFoundProducts(String product) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().contains(product)){
                return this;
            }
        }
        Assert.fail("Не нашлось подъходящего продукта");
        return this;
    }

    @Step("Сортировка по цене")
    public CatalogPage sortByPrice(String typeSort) {
        List<WebElement> sort = findElementsByXpath(elementLocators.SORT);
        scrollToElementJs(sort.get(0));
        switch (typeSort){
            case("По популярности"):
                waitUtilElementToBeClickable(sort.get(0)).click();
                break;
            case("По цене"):
                waitUtilElementToBeClickable(sort.get(1)).click();
                break;
            case("По рейтингу"):
                waitUtilElementToBeClickable(sort.get(2)).click();
                break;
            case("По скидке"):
                waitUtilElementToBeClickable(sort.get(3)).click();
                break;
            default:
                Assert.fail("Не правильно выбрана сортировка");
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        listener.getScreenshot();
        return this;
    }
    @Step("Выбрать первый продукт")
    public ProductPage selectFirstProduct() {
        findElementByXpath(elementLocators.NAME_OF_PRODUCTS).click();

        /** тут реализован переход на новую страницу */
        String originalWindow = DriverManager.getDriverManager().getDriver().getWindowHandle();
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : DriverManager.getDriverManager().getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                DriverManager.getDriverManager().getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        listener.getScreenshot();
        return PageManager.getPageManager().getProductPage();
    }
}
