package calculations;

import operation.Operation;

public class Calculations {
    public static int add(int firstTerm, int secondTerm) {
        return firstTerm + secondTerm;
    }

    public static int substract(int firstTerm, int secondTerm) {
        return firstTerm - secondTerm;
    }

    public static int mult(int firstTerm, int secondTerm) {
        return firstTerm * secondTerm;
    }

    public static double divide(int firstTerm, int secondTerm) {
        return firstTerm / secondTerm;
    }

    public static int calculate(int firstTerm, int secondTerm, int operationNumber) {
        int answer = 0;
        if (operationNumber == Operation.ADD.ordinal()) {
            answer = Calculations.add(firstTerm, secondTerm);
        } else if (operationNumber == Operation.SUBTRACT.ordinal()) {
            answer = Calculations.substract(firstTerm, secondTerm);
        } else if (operationNumber == Operation.MULTIPLY.ordinal()) {
            answer = Calculations.mult(firstTerm, secondTerm);
        } else if (operationNumber == Operation.DIVIDE.ordinal()) {
            double answer1 = Calculations.divide(firstTerm, secondTerm);
            answer = (int) answer1;
        }
        return answer;
    }
}