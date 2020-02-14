package context;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 29.01.2020
 **/
public class AppiumDriver {

    public static AndroidDriver driver;

    public AndroidDriver getAndroidDriver(AppiumDriverLocalService service, String url, String platform, String deviceName, String udid, String wdaLocalPort, String appPath, String config_file, String environment) throws Exception {

        String name = System.getProperty("driver");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String[] platformInfo = platform.split(" ");
        JSONParser parser = new JSONParser();

        if (name.equals("androidApp")) {
            JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/config/" + config_file));

            Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
            commonCapabilities.put("platformName", platformInfo[0]);
            commonCapabilities.put("platformVersion", platformInfo[1]);
            commonCapabilities.put("deviceName", deviceName);


            Iterator it = commonCapabilities.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if (capabilities.getCapability(pair.getKey().toString()) == null) {
                    capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
                }
            }

//            driver = new AndroidDriver(service, capabilities);
            driver = new AndroidDriver(new URL(url), capabilities);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;

    }

}


