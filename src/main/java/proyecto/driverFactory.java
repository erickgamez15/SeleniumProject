package proyecto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class driverFactory {
    public static WebDriver chromeInitialize(){
        System.setProperty(
                "webdriver.chrome.driver","D:\\Users\\erick\\OneDrive\\Documentos\\IntelliJ Projects\\ProyectoSeccion27\\src\\main\\resources\\chromedriver.exe"
        );
        return new ChromeDriver();
    }

    public static WebDriver firefoxInitialize(){
        System.setProperty(
                "webdriver.gecko.driver","D:\\Users\\erick\\OneDrive\\Documentos\\IntelliJ Projects\\ProyectoSeccion27\\src\\main\\resources\\geckodriver.exe"
        );
        return new FirefoxDriver();
    }

    public static WebDriver internetExplorerInitialize(){
        System.setProperty(
                "webdriver.chrome.driver","C:\\Users\\109117781\\Documents\\IntelliJ Projects\\ProyectoSeccion27\\src\\main\\resources\\chromedriver.exe"
        );
        return new InternetExplorerDriver();
    }
}
