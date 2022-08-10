package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;
    public LandingPage(WebDriver driver) { this.driver = driver; }

    //Forma corta de ponerlo con expresión regular. Forma Larga: a[href='https://rahulshettyacademy.com/sign_in/']
    private final By signing = By.cssSelector("a[href*='sign_in']");
    private final By title = By.cssSelector("div[class='text-center'] h2");
    private final By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

    public LoginPage getLogin() {
        driver.findElement(signing).click();
        return new LoginPage(driver);
    }
    public WebElement getTitle() {
        return driver.findElement(title);
    }
    public WebElement getNavigationBar() {
        return driver.findElement(navBar);
    }

}
