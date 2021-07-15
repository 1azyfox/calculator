public class RomeDigits {
    public static StringBuilder exec(String firstTerm, String secondTerm, int operationNumber) throws MyException {
            int firstDigit = Transfer.romeToArabTransfer(firstTerm);
            int secondDigit = Transfer.romeToArabTransfer(secondTerm);
            StringBuilder answer = Transfer.arabToRomeTransfer(Calculations.calculate(firstDigit, secondDigit, operationNumber));
            return answer;
    }
}
