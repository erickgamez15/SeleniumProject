package proyecto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class driverFactory {
    public static WebDriver chromeInitialize(){
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe"
        );
        return new ChromeDriver();
    }

    public static WebDriver firefoxInitialize(){
        System.setProperty(
                "webdriver.gecko.driver",
                System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe"
        );
        return new FirefoxDriver();
    }

    public static WebDriver internetExplorerInitialize(){
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe"
        );
        return new InternetExplorerDriver();
    }
}
