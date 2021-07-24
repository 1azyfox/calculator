package calculator.service.digit.arab;

import calculator.operation.Operation;
import calculator.service.digit.Digits;

public class ArabDigits extends Digits {

    @Override
    public String exec(String a, String b, Operation operation) {
        int firstDigit = Integer.parseInt(a);
        int secondDigit = Integer.parseInt(b);
        return String.valueOf(getCalculations()
                .calculate(firstDigit, secondDigit, operation));
    }
}
