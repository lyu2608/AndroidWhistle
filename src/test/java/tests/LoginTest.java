package tests;

import com.automation.remarks.video.annotations.Video;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import video.SpecializedScreenRecorder;

/**
 * Created by User on 30.01.2020
 **/

//@Listeners(UniversalVideoListener.class)
public class LoginTest extends BaseTest {
    private BasePage basePage;
    private LoginPage loginPage;
    public SpecializedScreenRecorder specializedScreenRecorder;

    @BeforeMethod
    public void setUp() {
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Story("Positive cases")
    @Feature("Login")
    @Test
    public void testLoginPositive() {

        loginPage.login("123456");
//        basePage.waitVisibilityOfElementMobile(loginPage.getEvents());
        Assert.assertTrue(loginPage.getEvents().isDisplayed());
    }

    @Story("Negative Cases")
    @Feature("Login")
    @Test
    @Video(name = "first_video")
    public void testLoginNegative() throws Exception {

        specializedScreenRecorder.startRecording();

        loginPage.login("12");
//        basePage.waitVisibilityOfElementMobile(loginPage.getEvents());
        Assert.assertTrue(loginPage.getEvents().isDisplayed());

        specializedScreenRecorder.stopRecording();
    }

    @Story("Positive cases")
    @Feature("Page test1")
    @Test
    public void testDND() {
        loginPage.login("123456");

    }
}
