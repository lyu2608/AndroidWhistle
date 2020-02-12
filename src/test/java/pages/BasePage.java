package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by User on 29.01.2020
 **/
public class BasePage {

    public AndroidDriver driver;
    public WebDriverWait wait;
    private static Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void waitVisibilityOfElementMobile(WebElement element){
        (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOf(element));
    }


    public void waitInvisibilityOfElementMobile(MobileElement element){
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.invisibilityOf(element));
    }

}
