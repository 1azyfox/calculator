package calculations;

import operation.Operation;

public class Calculations{

    public static int add(int firstTerm, int secondTerm) {
        return firstTerm + secondTerm;
    }

    public static int subtract(int firstTerm, int secondTerm) {
        return firstTerm - secondTerm;
    }

    public static int multiply(int firstTerm, int secondTerm) {
        return firstTerm * secondTerm;
    }

    public static int divide(int firstTerm, int secondTerm) {
        return firstTerm / secondTerm;
    }

    public static int calculate(int firstTerm, int secondTerm, int operationNumber) {
        int answer = 0;
        if (operationNumber == Operation.ADD.ordinal()) {
            answer = Calculations.add(firstTerm, secondTerm);
        } else if (operationNumber == Operation.SUBTRACT.ordinal()) {
            answer = Calculations.subtract(firstTerm, secondTerm);
        } else if (operationNumber == Operation.MULTIPLY.ordinal()) {
            answer = Calculations.multiply(firstTerm, secondTerm);
        } else if (operationNumber == Operation.DIVIDE.ordinal()) {
            answer = Calculations.divide(firstTerm, secondTerm);
        }
        return answer;
    }
}