package testcases;

import driver.DriverManager;
import driver.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SearchPage;
import steps.HomePageStep;

import java.util.concurrent.TimeUnit;

public class SearchTest {

    WebDriver driver;
    DriverManager driverManager;

    @BeforeTest
    public void setup(){
        driverManager = DriverManagerFactory.getDriverManager(DriverManagerFactory.DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://openweathermap.org/");
    }


    @Test(dataProvider = "provideValidSearchData")
    public void searchWithValidCityName(String city){
        HomePageStep homePageStep = new HomePageStep(driver);
        SearchPage searchPage = homePageStep.searchFromHomePage(city);
        Assert.assertTrue(searchPage.isCityNameDisplayedInFirstResult(city),"Checking if the city name is displayed in first result");
    }

    @Test
    public void searchWithInValidCityName(){
        HomePageStep homePageStep = new HomePageStep(driver);
        SearchPage searchPage = homePageStep.searchFromHomePage("londonallallalalalalalal");
        Assert.assertTrue(searchPage.isLblNotFoundDisplayed(),"Checking if the Not Found label is displayed");
    }

    @DataProvider (name = "provideValidSearchData")
    public Object[][] validSearchData(){
        return new Object[][] {{"London, US"},{"London, GB"},{"Vietnam"}};
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
