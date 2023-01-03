package proyecto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;

import java.io.IOException;

public class HomePage extends base{
    public WebDriver driver;
    public static Logger logger = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
    }

    @Test(dataProvider = "getData")//Parametro para el test
    public void basePageNavigation(String username,String password,String text) {
        driver.get(properties.getProperty("url"));
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.getLogin();
        loginPage.getEmail().sendKeys(username);
        loginPage.getPassword().sendKeys(password);
        //System.out.println(text);
        logger.info(text);
        loginPage.getLogin().click();
        ForgotPassword fPassword = loginPage.forgotPassword();
        fPassword.getEmail().sendKeys("asdfghj");
        fPassword.sendMeInstructions().click();
    }

    @AfterTest
    public void teardown() { driver.close(); }

    @DataProvider
    public Object[][] getData(){
        //Las filas son para los diferentes tipos de datos que se deben probar
        //Y las columnas para cuantos valores por cada test
        Object[][] data = new Object[2][3];
        //Datos enviados a la posición 0,0
        data[0][0] = "nonrestricteduser@gmail.com";
        data[0][1] = "1234asd";
        data[0][2] = "Restricted User";
        //Datos a la posición 1,0
        data[1][0] = "restricteduser@gmail.com";
        data[1][1] = "sdfg2345";
        data[1][2] = "Non Restricted User";
        return data;
    }
}
