package ru.appline.framework.pages;
import org.openqa.selenium.By;

public class ElementLocators {

    By FIELD_SEARCH_FOR_CHECK_OPEN = By.xpath("//a[@id=\"logoPartMarket\"]");
    By SEARCH = By.xpath("//input[@id=\"header-search\"]");
    By FIND_BUTTON = By.xpath("//button[@data-r=\"search-button\"]");
    By SCROLL_TO_BOTTOM = By.xpath("//h2[contains(text(), \"Рекомендации на основе просмотренного\")]");
    By NAME_OF_PRODUCTS = By.xpath("//article[@data-autotest-id=\"product-snippet\"]//a[@data-baobab-name=\"title\"]");
    By PRICE_OF_PRODUCTS = By.xpath("//article[@data-autotest-id=\"product-snippet\"]//span[@data-auto=\"mainPrice\"]/span[1]");
    By SORT = By.xpath("//div[@data-grabber=\"SearchControls\"]//button");
    By SHOP = By.xpath("//a[@data-zone-name=\"offerLink\"]");
    By PRICE = By.xpath("//div[@data-apiary-widget-name=\"@MarketNode/RecommendedOffers\"]//span[2]");
}
