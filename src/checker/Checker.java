package checker;

import arab.ArabDigitCondition;
import exceptions.CalculatorExceptions;
import insert.InsertDto;
import operation.Operation;
import rome.RomeNumber;
import transfer.Transfer;

import java.nio.charset.StandardCharsets;

public class Checker {
    public static boolean isTermArabDigit(String term) {
        int minArab = ArabDigitCondition.MIN_ARAB_DIGIT.getValue();
        int maxArab = ArabDigitCondition.MAX_ARAB_DIGIT.getValue();
        try {
            int a = Integer.parseInt(term);
            return a >= minArab && a <= maxArab;
        } catch (NumberFormatException e) {
            return false;
        }
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
                    break;
                }
            }
        }
        return isTermFromRomeDigits;
    }

    public static boolean isTermRomeNumber(String term) throws CalculatorExceptions {
        if (isTermFromRomeDigits(term)) {
            Transfer.romeToArabTransfer(term);
            return true;
        }
        return false;
    }

    public static boolean isArabTermCheckUp(String term) throws CalculatorExceptions {
        return isTermArabDigit(term) && isArabTermInt(term) && isArabTermInConditions(term);
    }

    public static boolean isTermsFullCheckUp(String firstTerm, String secondTerm) throws CalculatorExceptions {
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

    public static boolean isFullCheckUp(String firstTerm, String secondTerm, String operation) throws CalculatorExceptions {
        return isTermsFullCheckUp(firstTerm, secondTerm) & isOperationInConditions(operation);
    }

    public static boolean isFullCheckUp(InsertDto insertDto) throws CalculatorExceptions {
        String firstTerm = insertDto.getFirstTerm();
        String secondTerm = insertDto.getSecondTerm();
        String operation = insertDto.getOperation();
        return isTermsFullCheckUp(firstTerm, secondTerm) & isOperationInConditions(operation);
    }


    public static boolean isTermsMatch(String firstTerm, String secondTerm) throws CalculatorExceptions {
        if (isBothTermsArab(firstTerm, secondTerm) | isBothTermsRome(firstTerm, secondTerm)) {
            return true;
        } else {
            throw new CalculatorExceptions(CalculatorExceptions.MISMATCHED_EXPRESSION_FORMAT);
        }
    }

    public static boolean isBothTermsArab(String firstTerm, String secondTerm) {
        return isTermArabDigit(firstTerm) & isTermArabDigit(secondTerm);
    }

    public static boolean isBothTermsRome(String firstTerm, String secondTerm) throws CalculatorExceptions {
        return isTermRomeNumber(firstTerm) & isTermRomeNumber(secondTerm);
    }

    public static boolean isArabTermInt(String a) throws CalculatorExceptions, NumberFormatException {
//        try {
        double term = Double.parseDouble(a);
        if (term % 1 == 0) {
            return true;
        } else {
            throw new CalculatorExceptions(CalculatorExceptions.ARAB_NUMBER_NOT_INTEGER);
        }
//        } catch (NumberFormatException e) {
//            throw new CalculatorExceptions("неверный ввод числа");
//        }
    }

    public static boolean isArabTermInConditions(String a) throws CalculatorExceptions {
        double term = Double.parseDouble(a);
        if (term >= ArabDigitCondition.MIN_ARAB_DIGIT.getValue() & term <= ArabDigitCondition.MAX_ARAB_DIGIT.getValue()) {
            return true;
        } else {
            throw new CalculatorExceptions(CalculatorExceptions.ARAB_NUMBER_OUTSIDE_CONDITIONS);
        }
    }

    public static boolean isOperationInConditions(String operation) throws CalculatorExceptions {
        boolean isOperationInConditions = false;
        char[] symbolsOperation = operation.toCharArray();
        if (symbolsOperation.length == 1) {
            char a;
            for (Operation operation1 : Operation.values()) {
                a = operation1.getOperationSymbol();
                if (symbolsOperation[0] == a) {
                    isOperationInConditions = true;
                    return isOperationInConditions;
                } else {
                    throw new CalculatorExceptions(CalculatorExceptions.OPERATION_INSERT_WRONG);
                }
            }
        } else {
            throw new CalculatorExceptions(CalculatorExceptions.OPERATION_INSERT_WRONG);
        }
        return isOperationInConditions;
    }
}