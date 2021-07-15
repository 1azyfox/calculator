public class ArabDigits {
    public static int exec(String a, String b, int operationNumber) {
            int firstDigit = Integer.parseInt(a);
            int secondDigit = Integer.parseInt(b);
            return Calculations.calculate(firstDigit, secondDigit, operationNumber);

    }
}
