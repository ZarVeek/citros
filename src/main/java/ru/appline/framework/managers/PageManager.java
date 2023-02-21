package ru.appline.framework.managers;

import ru.appline.framework.pages.CatalogPage;
import ru.appline.framework.pages.HomePage;
import ru.appline.framework.pages.ProductPage;

/**
 * @author Artem_Kireev
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private HomePage homePage;

    /**
     * Каталоговая страничка
     */
    private CatalogPage catalogPage;

    /**
     * Продуктовая страничка
     */
    private ProductPage productPage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link HomePage}
     *
     * @return StartPage
     */
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    /**
     * Ленивая инициализация {@link CatalogPage}
     *
     * @return CatalogPage
     */

    public CatalogPage getCatalogPage() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        return catalogPage;
    }

    /**
     * Ленивая инициализация {@link ProductPage}
     *
     * @return ProductPage
     */

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }



}
