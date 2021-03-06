package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by User on 30.01.2020
 **/
public class LoginPage extends BasePage {

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//android.widget.EditText[@text='EMAIL']")
    private WebElement email;

    @FindBy(xpath = "//android.widget.TextView[@text='Change domain']")
    private WebElement domain;

    @FindBy(xpath = "//android.widget.Button[@text='LOGIN']")
    private WebElement login;

//    @FindBy(xpath = "//android.widget.Button[@text='OK']")
//    private WebElement ok;

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
//   android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.FrameLayout
    private WebElement ok;

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    private WebElement meeting;

    @FindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[@text='Events screen']")
//    android.widget.LinearLayout/android.widget.TextView
    private WebElement events;



    private String loginStr = "yuliia.lypovetska@codeit.pro";


    public WebElement pinClick(char number) {
        return driver.findElement(By.xpath("//android.widget.Button" + "[@text = '" + number + "']"));
    }

    @Step("Login to system")
    public void login(String password) {
//        TouchAction touch = new TouchAction(driver);
//        touch.tap(TapOptions.tapOptions().withElement(element(domain))).perform();
//        touch.tap(TapOptions.tapOptions().withElement(element(login))).perform();

        char[] passArray = password.toCharArray();
        domain.click();
        email.click();
        email.sendKeys(loginStr);
        login.click();

        for (int i = 0; i < passArray.length; i++) {
            pinClick(passArray[i]).click();
        }

        ok.click();

        driver.isAppInstalled("com.lyricalcare.whistle");

        System.out.println("IsInstalled = " + driver.isAppInstalled("com.lyricalcare.whistle"));

    }




    public WebElement getEvents() {
        return events;
    }

}
