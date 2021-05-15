package driver;

public class DriverManagerFactory {
    public enum DriverType{
        CHROME,
        FIREFOX
    }

    public static DriverManager getDriverManager(DriverType type){
        DriverManager driverManager;
        switch (type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;

            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;

            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }
}
