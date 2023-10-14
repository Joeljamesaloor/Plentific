package Helpers;

import Screens.CalculatorPage;

public class clickNumber {

    private final CalculatorPage calculatorPage;

    public clickNumber(CalculatorPage calculatorPage) {
        this.calculatorPage = calculatorPage;
    }

    public void clickNumber(int number) {
        // Convert the number to a string to process each digit
        String numberStr = Integer.toString(number);

        // For each digit in the number, click the appropriate button
        for (char digit : numberStr.toCharArray()) {
            int digitAsInt = Character.getNumericValue(digit);
            calculatorPage.clickNumber(digitAsInt);
        }
    }
}
