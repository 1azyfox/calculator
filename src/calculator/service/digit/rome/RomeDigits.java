package calculator.service.digit.rome;

import calculator.exception.CalculatorExceptions;
import calculator.operation.Operation;
import calculator.service.digit.Digits;
import calculator.service.transfer.Transfer;

public class RomeDigits extends Digits {
    @Override
    public String exec(String firstTerm, String secondTerm, Operation operation) throws CalculatorExceptions {
        int firstDigit = Transfer.romeToArabTransfer(firstTerm);
        int secondDigit = Transfer.romeToArabTransfer(secondTerm);
        return Transfer.arabToRomeTransfer(getCalculations()
                .calculate(firstDigit, secondDigit, operation));
    }
}
