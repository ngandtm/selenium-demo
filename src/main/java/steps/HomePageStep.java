package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchPage;

public class HomePageStep {
    WebDriver driver;
    public HomePageStep(WebDriver driver) {
        this.driver= driver;
    }

    public SearchPage searchFromHomePage(String city){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSearchTextBox();
        homePage.searchWeatherByCity(city);
        homePage.hitEnter();
        return new SearchPage(driver);
    }
}
