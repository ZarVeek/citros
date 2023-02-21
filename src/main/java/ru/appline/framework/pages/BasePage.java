package ru.appline.framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.utils.Item;
import ru.appline.framework.utils.MyListener;
import java.util.ArrayList;
import java.util.List;

public class BasePage{

    /** инициализация переменных */
    protected final DriverManager driverManager = DriverManager.getDriverManager();

    protected PageManager pageManager = PageManager.getPageManager();

    protected Actions action = new Actions(driverManager.getDriver());

    protected JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();

    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 10, 1000);

    protected List<Item> products = new ArrayList<>();

    MyListener listener = new MyListener();

    ElementLocators elementLocators = new ElementLocators();



    /** скролл до элемента с помощью js */
    protected WebElement scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }
    /** клик на элемент с помощью js */
    protected WebElement clickToElementJs(WebElement element) {
        js.executeScript("arguments[0].click();", element);
        return element;
    }

    /** ожидание опка элемент будет кликабельный */
    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /** ожидание опка элемент будет виден */
    protected WebElement waitUtilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /** ожидание стабилизации страницы */
    protected void waitStabilityPage(int maxWaitMillis, int pollDelimiter){
        double startTime = System.currentTimeMillis();
        while (System.currentTimeMillis()<startTime + maxWaitMillis){
            String prevState = driverManager.getDriver().getPageSource();
            wait(pollDelimiter);
            if(prevState.equals(driverManager.getDriver().getPageSource())){
                return;
            }
        }
    }

    /** ожидание */
    protected void wait(int mlSec){
        try {
            Thread.sleep(mlSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /** поиск эелемента */
    protected WebElement findElementByXpath(By path){
        return driverManager.getDriver().findElement(path);
    }
    /** поиск эелементов */
    protected List<WebElement> findElementsByXpath(By path){
        return driverManager.getDriver().findElements(path);
    }

}
