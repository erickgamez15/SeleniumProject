package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) { this.driver = driver; }

    private final By email = By.id("user_email");
    private final By password = By.id("user_password");
    private final By login = By.cssSelector("input[value='Log In']");
    private final By forgotPassword = By.cssSelector(".link-below-button");
    public WebElement getEmail() {
        return driver.findElement(email);
    }
    public WebElement getPassword() {
        return driver.findElement(password);
    }
    public WebElement getLogin() {
        return driver.findElement(login);
    }
    public ForgotPassword forgotPassword() {
        driver.findElement(forgotPassword).click();
        return new ForgotPassword(driver);
    }
}
