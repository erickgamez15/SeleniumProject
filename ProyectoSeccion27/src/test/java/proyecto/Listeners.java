package proyecto;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends base implements ITestListener {
    ExtentTest extentTest;
    ExtentReports extentReports = ExtentReportsNG.getReportObject();//Para evitar crear un objeto de clase, por ello está declarado static en ExtentReportsNG
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        //ExtentReports here
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        test.set(extentTest);//Para dar reportes que fallen de la manera correcta a la hora de ejecutar
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        test.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        test.get().fail(result.getThrowable());
        //Screenshot here
        WebDriver driver =null;
        String testMethodName= result.getMethod().getMethodName();
        try {
            driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch(Exception ignored) {
        }
        try { //Primero recibe la ruta donde se guardará el archivo y segundo es el nombre que se le dara al archivo
            //Para tomar captura del error en la pagina de reportes y aparezca ahí mismo
            test.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver),result.getMethod().getMethodName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extentReports.flush();
    }
}
