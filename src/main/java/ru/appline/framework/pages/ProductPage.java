package ru.appline.framework.pages;

import io.qameta.allure.Step;

import static ru.appline.framework.pages.ElementLocators.*;

public class ProductPage extends BasePage{
    @Step("Вывести в консоль магазин и цену продукта")
    public ProductPage soutShopAndPrice(){
        System.out.println("Магазин: " + findElementByXpath(elementLocators.SHOP).getText());
        System.out.println("Цена: " + findElementByXpath(elementLocators.PRICE).getText());
        return this;
    }
}
