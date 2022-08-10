package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) { this.driver = driver; }

    By email = By.id("user_email");
    By password = By.id("user_password");
    By login = By.cssSelector("input[value='Log In']");
    By forgotPassword = By.cssSelector(".link-below-button");
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
