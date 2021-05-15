package pages;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BaseElement {
    WebDriver driver;
    private WebDriverWait wait;


    public BaseElement(WebDriver driver){
        this.driver= driver;
    }

    public WebElement waitForElement(By by, int timeOut) {
        try {
            wait = new WebDriverWait(driver, timeOut);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return element;
        } catch (WebDriverException e) {
            throw new RuntimeException("Not able to find the element " + by, e);
        }
    }

    public List<WebElement> getListElements(By by,int timeOut) {
        try {
            wait = new WebDriverWait(driver, timeOut);
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            return elements;
        } catch (WebDriverException e) {
            throw new RuntimeException("Not able to find the element " + by, e);
        }
    }

    public void click(By by){
        waitForElement(by,10).click();
    }

    public void senKeys(By by, String message){
        WebElement element = waitForElement(by, 10);
        element.sendKeys(message);
    }
}
