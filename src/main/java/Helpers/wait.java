package Helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait {
    private AppiumDriver<MobileElement> driver;
    private final int DEFAULT_TIMEOUT = 30; // default wait time in seconds

    public wait(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    /**
     * Waits until the element is displayed.
     *
     * @param element MobileElement to wait for.
     * @return true if element is displayed, false otherwise.
     */
    public boolean waitForElementToDisplay(MobileElement element) {
        return waitForElementToDisplay(element, DEFAULT_TIMEOUT);
    }

    public boolean waitForElementToDisplay(MobileElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}

