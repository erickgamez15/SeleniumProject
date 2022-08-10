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

public class validateTitle extends base{
    public WebDriver driver;
    public static Logger logger = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        logger.info("Driver is initialized");
        driver.get(properties.getProperty("url"));
        logger.info("Navigated to Home page");
    }
    @Test
    public void validateAppTitle() {
        //one is inheritance
        // creating object to that class and invoke methods of it
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES");
        logger.info("Successfully validated Text message");
        System.out.println("Test completed");
    }

    @AfterTest
    public void teardown() { driver.close(); }
}
