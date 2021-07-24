package calculator.execution;

import calculator.operation.Operation;
import calculator.service.digit.arab.ArabDigits;
import calculator.service.digit.rome.RomeDigits;
import calculator.exception.CalculatorExceptions;
import calculator.dto.InsertDto;
import calculator.service.checker.Checker;

public class Execution {
    public static void execution(InsertDto insertDto) throws CalculatorExceptions {
        String firstTerm = insertDto.getFirstTerm();
        String secondTerm = insertDto.getSecondTerm();
        String operation = insertDto.getOperation();
        if (Checker.isFullCheckUp(firstTerm, secondTerm, operation)) {
            if (Checker.isBothTermsArab(firstTerm, secondTerm)) {
                System.out.println("Ответ=" + ArabDigits.exec(firstTerm, secondTerm, Operation.findBySymbol(operation)));
            } else {
                if (Checker.isBothTermsRome(firstTerm, secondTerm)) {
                    System.out.println("Ответ=" + RomeDigits.exec(firstTerm, secondTerm, Operation.findBySymbol(operation)));
                }
            }
        }
    }
}
