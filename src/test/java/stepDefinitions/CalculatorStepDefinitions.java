package stepDefinitions;

import Screens.CalculatorPage;
import driver.AppiumDriverSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalculatorStepDefinitions {

    private AppiumDriver<MobileElement> driver;
    private CalculatorPage calculatorPage;
    private String operation;
    private int num1, num2;

    @Given("I launch the calculator app")
    public void i_launch_the_calculator_app() {
        driver = AppiumDriverSetup.getDriver();
        calculatorPage = new CalculatorPage(driver);
    }

    @When("^I ([^\"]*) (\\d+) and (\\d+)$")
    public void i_perform_operation(String operation, int num1, int num2) {
        this.operation = operation;
        this.num1 = num1;
        this.num2 = num2;

        calculatorPage.clickNumber(num1);

        switch (operation) {
            case "add":
                calculatorPage.clickAdd();
                break;

            case "subtract":
                calculatorPage.clickSubtract();
                break;

            case "multiply":
                calculatorPage.clickMultiply();
                break;

            case "divide":
                calculatorPage.clickDivide();
                break;
        }

        calculatorPage.clickNumber(num2);
        calculatorPage.clickEquals();

    }

    @Then("the result should be correct")
    public void the_result_should_be_correct() {
        int expectedResult = 0;
        switch (operation) {
            case "add":
                expectedResult = num1 + num2;
                break;

            case "subtract":
                expectedResult = num1 - num2;
                break;

            case "multiply":
                expectedResult = num1 * num2;
                break;

            case "divide":
                expectedResult = num1 / num2;
                break;
        }
        Assert.assertEquals(expectedResult, calculatorPage.getResult());
        calculatorPage.clickACButton();
    }

    @When("I divide {int} by 0")
    public void i_divide_by_zero(int num) {
        calculatorPage.clickNumber(num);
        calculatorPage.clickDivide();
        calculatorPage.clickNumber0();
        calculatorPage.clickEquals();
    }

    @Then("the calculator should display {string}")
    public void the_calculator_should_display(String expectedDisplay) {
        Assert.assertEquals(expectedDisplay, calculatorPage.getDisplayText());
        calculatorPage.clickACButton();
    }

}
