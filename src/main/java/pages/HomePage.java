package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseElement {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    By txtSearch = By.xpath("//div[@id='desktop-menu']//form[contains(@role,'search')]//input[@type='text']");

    By btnSubmit = By.xpath("//div[@id='desktop-menu']//form[contains(@role,'search')]//input[@type='submit']");

//    @FindBy(xpath = "//div[@id='desktop-menu']//form[contains(@role,'search')]//input[@type='text']")
//    private WebElement txtSearch;

    public void clickOnSearchTextBox(){
       click(txtSearch);
    }

    public void searchWeatherByCity(String city){
        senKeys(txtSearch,city);
    }

    public SearchPage hitEnter(){
        waitForElement(txtSearch,10).sendKeys(Keys.RETURN);
        return new SearchPage(driver);
    }
}
