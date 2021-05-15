package driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class FirefoxDriverManager extends DriverManager {

    protected void createWebDriver() {
        FirefoxOptions options= new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", "src/main/java/driver/geckodriver");
        this.driver = new FirefoxDriver(options);
    }
}
