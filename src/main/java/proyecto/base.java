package proyecto;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class base {
    //Método reusable para inicializar el driver
    public WebDriver driver;
    public Properties properties;
    public WebDriver initializeDriver() throws IOException {
        properties = new Properties();
        FileInputStream file = new FileInputStream(
                "D:\\Users\\erick\\OneDrive\\Documentos\\IntelliJ Projects\\ProyectoSeccion27\\src\\main\\resources\\data.properties"
        );
        properties.load(file); //To load file
        String browserName = properties.getProperty("browser"); //Para poder tomar el browser del archivo .properties
        switch (browserName) {
            case "chrome" -> driver = driverFactory.chromeInitialize();
            case "firefox" -> driver = driverFactory.firefoxInitialize();
            case "IE" -> driver = driverFactory.internetExplorerInitialize();
            default -> JOptionPane.showMessageDialog(null, "Driver not found");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);//Para tomar la captura de pantalla
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
}
