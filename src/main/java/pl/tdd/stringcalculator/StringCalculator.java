package pl.tdd.stringcalculator;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String input) {
        return input.isEmpty()
                ? 0
                : sumElements(input.split(","));
    }

    private int sumElements(String[] splittedInput) {

        if(splittedInput.length == 2) {
            return parseInt(splittedInput[0]) + parseInt(splittedInput[1]);
        }

        return parseInt(splittedInput[0]);
    }
}
