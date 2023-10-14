package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class AppiumDriverSetup {
    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("deviceName", "emulator");
                caps.setCapability("platformName", "Android");
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability("app", "/Users/joeljamesaloor/AndroidStudioProjects/October Project2/build/app/outputs/apk/release/app-release.apk");
                caps.setCapability("appPackage", "felipecastrosales.calculator");
                caps.setCapability("appActivity", "felipecastrosales.calculator.MainActivity");
                caps.setCapability("appWaitActivity", "felipecastrosales.calculator.SplashActivity,felipecastrosales.calculator.MainActivity");
                caps.setCapability("noReset", true);
                caps.setCapability("fullReset", false);

                driver = new AndroidDriver<>(new URL("http://localhost:4723/"), caps);

            } catch (TimeoutException e) {
                throw new RuntimeException("Failed to find the element after waiting for 30 seconds", e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
