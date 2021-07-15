import java.util.NoSuchElementException;
import java.util.Scanner;

public class Insert {
    public static void runner(String expressionString) throws MyException, NoSuchElementException {
        Scanner scanner = new Scanner(expressionString);
        try {
            String firstTerm = scanner.next();
            String operation = scanner.next();
            String secondTerm = scanner.next();
            if (Checker.isFullCheckUp(firstTerm, secondTerm, operation)) {
                if (Checker.isBothTermsArab(firstTerm, secondTerm)) {
                    System.out.println("Ответ=" + ArabDigits.exec(firstTerm, secondTerm, FindOperation.getOperationNumber(operation)));
                } else {
                    if (Checker.isBothTermsRome(firstTerm, secondTerm)) {
                        System.out.println("Ответ=" + RomeDigits.exec(firstTerm, secondTerm, FindOperation.getOperationNumber(operation)));
                    }
                }
            }
        } catch (NoSuchElementException elementException) {
            throw new MyException("недопустимый ввод");
        }
    }

    public static boolean runnerIsProblems(String expressionString) throws MyException, NoSuchElementException {
        Scanner scanner = new Scanner(expressionString);
        String firstTerm = scanner.next();
        String operation = scanner.next();
        String secondTerm = scanner.next();
        return !(Checker.isFullCheckUp(firstTerm, secondTerm, operation));
    }
}
