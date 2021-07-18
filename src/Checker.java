import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Checker {
    public static boolean isTermArabDigit(String term)  {
        int minArab = ArabDigitCondition.MIN_ARAB_DIGIT.getValue();
        int maxArab = ArabDigitCondition.MAX_ARAB_DIGIT.getValue();
        try {
            int a = Integer.parseInt(term);

            return a >= minArab & a <= maxArab;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public static boolean isTermFromRomeDigits(String term) {
        boolean isTermFromRomeDigits = false;
        byte[] asciiTerm = term.getBytes(StandardCharsets.US_ASCII);
        int romeDigitConditionAmount = RomeNumber.values().length;
        int[] romeDigitConditionAsciiArray = new int[romeDigitConditionAmount];
        int x = 0;
        for (RomeNumber romeNumber : RomeNumber.values()) {
            while (x < romeDigitConditionAmount) {
                romeDigitConditionAsciiArray[x] = romeNumber.getAsciiSum();
                break;
            }
            x++;
        }
        for (byte i : asciiTerm) {
            for (int y : romeDigitConditionAsciiArray) {
                if (i == y) {
                    isTermFromRomeDigits = true;
                }
            }
        }
        return isTermFromRomeDigits;
    }


    public static boolean isTermRomeNumber(String term) throws MyException {
        boolean isTermRomeNumber = false;
        if (isTermFromRomeDigits(term)) {
            try {
                Transfer.romeToArabTransfer(term);
                return true;
            } catch (MyException e) {
                throw new MyException("недопустимый ввод римского числа");

            }
        }
        return isTermRomeNumber;
    }

    public static boolean isArabTermCheckUp(String term) throws MyException {
        return isTermArabDigit(term) && isArabTermInt(term) && isArabTermInConditions(term);
    }

    public static boolean isTermsFullCheckUp(String firstTerm, String secondTerm) throws MyException {
        boolean isTermsFullCheckUp = false;
        if (isTermsMatch(firstTerm, secondTerm)) {
            if (isArabTermCheckUp(firstTerm) & isArabTermCheckUp(secondTerm)) {
                isTermsFullCheckUp = true;
            } else {
                if (isTermRomeNumber(firstTerm)) {
                    isTermsFullCheckUp = true;
                }
            }
        }
        return isTermsFullCheckUp;
    }

    public static boolean isFullCheckUp(String firstTerm, String secondTerm, String operation) throws MyException {
        return isTermsFullCheckUp(firstTerm, secondTerm) & isOperationInConditions(operation);
    }

    public static boolean isTermsMatch(String firstTerm, String secondTerm) throws MyException {
        if (isBothTermsArab(firstTerm, secondTerm) | isBothTermsRome(firstTerm, secondTerm)) {
            return true;
        } else {
            throw new MyException("несовпадающий формат выражений");
        }
    }

    public static boolean isBothTermsArab(String firstTerm, String secondTerm) {
        return isTermArabDigit(firstTerm) & isTermArabDigit(secondTerm);
    }

    public static boolean isBothTermsRome(String firstTerm, String secondTerm) throws MyException {
        return isTermRomeNumber(firstTerm) & isTermRomeNumber(secondTerm);
    }

    public static boolean isArabTermInt(String a) throws MyException {
        try {
            double term = Double.parseDouble(a);
            if (term % 1 == 0) {
                return true;
            } else {
                throw new MyException("Вы ввели не целое число");
            }
        } catch (NumberFormatException e) {
            throw new MyException("неверный ввод числа");
        }

    }

    public static boolean isArabTermInConditions(String a) throws MyException {
        double term = Double.parseDouble(a);
        if (term >= ArabDigitCondition.MIN_ARAB_DIGIT.getValue() & term <= ArabDigitCondition.MAX_ARAB_DIGIT.getValue()) {
            return true;
        } else {
            throw new MyException("число за допустимыми пределами");
        }
    }

    public static boolean isOperationInConditions(String operation) throws MyException {
        boolean isOperationInConditions = false;
        char[] symbolsOperation = operation.toCharArray();
        if (symbolsOperation.length == 1) {
            char a;
            for (Operation operation1 : Operation.values()) {
                a = operation1.getOperationSymbol();
                if (symbolsOperation[0] == a) {
                    isOperationInConditions = true;
                    return isOperationInConditions;
                }
            }
        } else {
            throw new MyException("неверный ввод оператора");
        }
        return isOperationInConditions;
    }
}