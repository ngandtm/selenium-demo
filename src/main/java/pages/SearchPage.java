package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BaseElement{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    By btnSearchSubmit = By.xpath("//button[@type='submit']");
    By lblNotFound = By.xpath("//div[@id='forecast_list_ul']//div[contains(text(),'Not found')]");


    public boolean isBtnSearchDisplayed(){
        return waitForElement(btnSearchSubmit,10).isDisplayed();
    }

    public boolean isLblNotFoundDisplayed(){
        return waitForElement(lblNotFound,10).isDisplayed();
    }

    public List<WebElement> getListOfCityNameInSearchResult(String expectedCityname){
        return getListElements(By.xpath("//table[@class='table']//tbody//tr/td//b//a[contains(text(),'"+expectedCityname+"')]"),10);
    }

    public boolean isCityNameDisplayedInFirstResult(String expectedCityName){
        return getListOfCityNameInSearchResult(expectedCityName).get(0).isDisplayed();
    }
}
