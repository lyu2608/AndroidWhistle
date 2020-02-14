package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by User on 14.02.2020
 **/
public class DoNotDisturbPage extends BasePage {
    public DoNotDisturbPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"DND\"]")
    private WebElement dnd;

    @Step("Go to DoNotDisturb page")
    public void doNotDisturb() {

    }

}
