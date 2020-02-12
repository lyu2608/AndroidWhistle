package context;


import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import tests.BaseTest;

/**
 * Created by User on 05.02.2020
 **/
public class CustomTestListener extends TestListenerAdapter {
    private Logger log = LoggerFactory.getLogger(CustomTestListener.class);
//    AndroidDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test class started: " + result.getTestClass().getName());
        log.info("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test SUCCESS: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();
        AndroidDriver driver = (AndroidDriver) context.getAttribute("driver");
        saveScreenshot(driver);

        log.info("Test FAILED: " + result.getName());
        if (result.getThrowable()!=null) {
            result.getThrowable().printStackTrace();
        }

    }


        @Attachment(value = "Page screenshot", type = "image/png")
        public static byte[] saveScreenshot(AndroidDriver driver){

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
