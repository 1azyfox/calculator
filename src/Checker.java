public class Checker {
    public static boolean isTermArabDigit(String term) {
        char[] termSymbols = term.toCharArray();
        boolean isTermArabDigit = false;
        for (char i : termSymbols) {
            if (i > 48 & i < 58) {
                isTermArabDigit = true;
            }
            return isTermArabDigit;
        }
        return isTermArabDigit;
    }

    public static boolean isTermFromRomeDigits(String term) {
        char[] termSymbols = term.toCharArray();
        boolean isTermFromRomeDigits = false;
        for (char i : termSymbols) {
            if (i == 73 | i == 86 | i == 88) {
                isTermFromRomeDigits = true;
            }
            return isTermFromRomeDigits;
        }
        return isTermFromRomeDigits;
    }

    public static boolean isTermRomeNumber(String term) throws MyException {
        boolean isTermRomeNumber = false;
        if (isTermFromRomeDigits(term)) {
            try {
                Transfer.romeToArabTransfer(term);
                isTermRomeNumber = true;
                return isTermRomeNumber;
            } catch (MyException e) {
                throw new MyException("недопустимый ввод римского числа");
            }
        }
        return isTermRomeNumber;
    }

    public static boolean isArabTermCheckUp(String term) throws MyException {
        boolean isArabTermCheckUp;
        isArabTermCheckUp = isTermArabDigit(term) && isArabTermInt(term) && isArabTermInConditions(term);
        return isArabTermCheckUp;
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
        if (term > 0 & term < 11) {
            return true;
        } else {
            throw new MyException("число за допустимыми пределами");
        }
    }

    public static boolean isOperationInConditions(String operation) throws MyException {
        char[] symbolsOperation = operation.toCharArray();
        if (symbolsOperation.length == 1 & (symbolsOperation[0] == '+' |
                symbolsOperation[0] == '-' | symbolsOperation[0] == '*' | symbolsOperation[0] == '/')) {
            return true;
        } else {
            throw new MyException("неверный ввод оператора");
        }
    }
}