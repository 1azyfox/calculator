package execution;

import arab.ArabDigits;
import checker.Checker;
import exceptions.CalculatorExceptions;
import operation.FindOperation;
import rome.RomeDigits;
import insert.InsertDto;

public class Execution {
    public static void Execution(InsertDto insertDto) throws CalculatorExceptions {
        String firstTerm = insertDto.getFirstTerm();
        String secondTerm = insertDto.getSecondTerm();
        String operation = insertDto.getOperation();
        if (Checker.isFullCheckUp(firstTerm, secondTerm, operation)) {
            if (Checker.isBothTermsArab(firstTerm, secondTerm)) {
                System.out.println("Ответ=" + ArabDigits.exec(firstTerm, secondTerm, FindOperation.getOperationNumber(operation)));
            } else {
                if (Checker.isBothTermsRome(firstTerm, secondTerm)) {
                    System.out.println("Ответ=" + RomeDigits.exec(firstTerm, secondTerm, FindOperation.getOperationNumber(operation)));
                }
            }
        }
    }
}
