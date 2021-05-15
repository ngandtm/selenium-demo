package driver;

import org.openqa.selenium.WebDriver;

public abstract class  DriverManager {
        protected WebDriver driver;


        protected abstract void createWebDriver();


    public WebDriver getWebDriver() {
            if (driver == null){
                createWebDriver();
            }
        return driver;
    }
}
