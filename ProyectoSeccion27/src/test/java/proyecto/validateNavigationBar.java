package proyecto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class validateNavigationBar extends base{
    public WebDriver driver;
    public static Logger logger = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void validateAppNavBar() {
        //one is inheritance
        // creating object to that class and invoke methods of it
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.getNavigationBar().isDisplayed());
        logger.info("Navigation Bar is displayed");
        System.out.println("Test completed");
        //   Assert.assertFalse(false);
    }

    @AfterTest
    public void teardown() { driver.close(); }
}
