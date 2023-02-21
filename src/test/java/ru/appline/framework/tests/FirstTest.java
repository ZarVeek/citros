package ru.appline.framework.tests;
import org.testng.annotations.Test;
import ru.appline.framework.basetestsclass.BaseTests;


public class FirstTest extends BaseTests {

    @Test
    public void startTest() {
        app.getHomePage()
                .checkMainMenu()
                .searchProduct(pojoParams.getProductForSearch())
                .clickSearch()
                .takeListOfProducts()
                .checkFoundProducts(pojoParams.getProductForCheck())
                .sortByPrice(pojoParams.getSortType())
                .selectFirstProduct()
                .soutShopAndPrice();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
