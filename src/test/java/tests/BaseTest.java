package tests;

import com.browserstack.local.Local;
import context.AppiumDriver;
import context.CustomTestListener;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by User on 29.01.2020
 **/

public class BaseTest {

    BasePage basePage;
    AndroidDriver driver;
    private AppiumDriverLocalService service;



    @BeforeMethod(alwaysRun = true)
    @Parameters({"url", "platform", "deviceName", "udid", "wdaLocalPort", "appPath", "config", "environment"})
    public void setUp(@Optional String url, @Optional String platform, @Optional String deviceName, @Optional String udid, @Optional String wdaLocalPort, @Optional String appPath, @Optional String config_file, @Optional String environment) throws Exception {
        service = AppiumDriverLocalService.buildDefaultService();
        driver = new AppiumDriver().getAndroidDriver(service, url, platform, deviceName, udid, wdaLocalPort, appPath, config_file, environment);


    }

    @AfterClass
    public void tear() {

        service.stop();
    }


    @AfterMethod
    public void afterMethod(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SKIP) {
            saveScreenshot(driver);
            //        getVideo();
        }


        driver.closeApp();
//        driver.removeApp("com.lyricalcare.whistle");

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(AndroidDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "video", type = "video/mp4")
    private byte[] getVideo(File video) {
        try {
            return Files.readAllBytes(Paths.get(video.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

}
