package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import Helpers.wait;

public class CalculatorPage {

    private AppiumDriver<MobileElement> driver;
    private wait waitHelper;

    // Number locators
    private By button0 = By.xpath("//android.widget.Button[@content-desc='0']");
    private By button1 = By.xpath("//android.widget.Button[@content-desc='1']");
    private By button2 = By.xpath("//android.widget.Button[@content-desc='2']");
    private By button3 = By.xpath("//android.widget.Button[@content-desc='3']");
    private By button4 = By.xpath("//android.widget.Button[@content-desc='4']");
    private By button5 = By.xpath("//android.widget.Button[@content-desc='5']");
    private By button6 = By.xpath("//android.widget.Button[@content-desc='6']");
    private By button7 = By.xpath("//android.widget.Button[@content-desc='7']");
    private By button8 = By.xpath("//android.widget.Button[@content-desc='8']");
    private By button9 = By.xpath("//android.widget.Button[@content-desc='9']");
    private By addButton = By.xpath("//android.widget.Button[@content-desc='+']");
    private By subtractButton = By.xpath("//android.widget.Button[@content-desc='-']");
    private By divideButton = By.xpath("//android.widget.Button[@content-desc='/']");
    private By multiplyButton = By.xpath("//android.widget.Button[@content-desc='x']");
    private By equalsButton = By.xpath("//android.widget.Button[@content-desc='=']");
    private By ACButton = By.xpath("//android.widget.Button[@content-desc='AC']");
    private By resultView = By.xpath("//android.view.View[@content-desc]");

    public CalculatorPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.waitHelper = new wait(driver); // Initializing the wait helper
    }

    public void clickNumber(int number) {
        By locator;
        switch (number) {
            case 0:
                locator = button0;
                break;
            case 1:
                locator = button1;
                break;
            case 2:
                locator = button2;
                break;
            case 3:
                locator = button3;
                break;
            case 4:
                locator = button4;
                break;
            case 5:
                locator = button5;
                break;
            case 6:
                locator = button6;
                break;
            case 7:
                locator = button7;
                break;
            case 8:
                locator = button8;
                break;
            case 9:
                locator = button9;
                break;
            default:
                throw new IllegalArgumentException("Invalid number");
        }
        clickButton(locator);
    }

    private void clickButton(By locator) {
        MobileElement element = driver.findElement(locator);
        if (waitHelper.waitForElementToDisplay(element)) {
            element.click();
        }
    }

    public void clickAdd() {
        clickButton(addButton);
    }

    public void clickSubtract() {
        clickButton(subtractButton);
    }

    public void clickMultiply() {
        clickButton(multiplyButton);
    }

    public void clickDivide() {
        clickButton(divideButton);
    }

    public void clickEquals() {
        clickButton(equalsButton);
    }

    public int getResult() {
        MobileElement resultElem = driver.findElement(resultView);
        if (waitHelper.waitForElementToDisplay(resultElem)) {
            String contentDesc = resultElem.getAttribute("content-desc");
            return Integer.parseInt(contentDesc);
        }
        return 0;
    }

    public void clickACButton() {
        clickButton(ACButton);
    }

    public void clickNumber0() {
        clickButton(button0);
    }

    public String getDisplayText() {
        MobileElement displayElement = driver.findElement(resultView);
        if (waitHelper.waitForElementToDisplay(displayElement)) {
            return displayElement.getAttribute("content-desc"); // Assuming the displayed text is stored in the content-desc attribute.
        }
        return null;
    }

}