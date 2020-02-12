package tests;

import context.CustomTestListener;
import junit.framework.TestListener;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

/**
 * Created by User on 30.01.2020
 **/
public class LoginTest extends BaseTest {
    private BasePage basePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void testLogin() {

        loginPage.login();
//        basePage.waitVisibilityOfElementMobile(loginPage.getEvents());
        Assert.assertTrue(loginPage.getEvents().isDisplayed());


    }


}
