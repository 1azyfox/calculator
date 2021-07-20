package exceptions;

public class CalculatorExceptions extends Exception {

    public final static int ROME_NUMBER_INSERT_WRONG = 1;
    public final static int OPERATION_INSERT_WRONG = 2;
    public final static int ARAB_NUMBER_NOT_INTEGER = 3;
    public final static int MISMATCHED_EXPRESSION_FORMAT = 4;
    public final static int ARAB_NUMBER_OUTSIDE_CONDITIONS = 5;
    public final static int ROME_ZERO_DOES_NOT_EXIST = 6;

    public int code;

    public CalculatorExceptions (int code) {
        this.code = code;
    }
}
