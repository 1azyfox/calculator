package rome;

import calculations.Calculations;
import exceptions.CalculatorExceptions;
import transfer.Transfer;

public class RomeDigits {
    public static StringBuilder exec(String firstTerm, String secondTerm, int operationNumber) throws CalculatorExceptions {
        int firstDigit = Transfer.romeToArabTransfer(firstTerm);
        int secondDigit = Transfer.romeToArabTransfer(secondTerm);
        StringBuilder answer = Transfer.arabToRomeTransfer(Calculations.calculate(firstDigit, secondDigit, operationNumber));
        return answer;
    }
}
