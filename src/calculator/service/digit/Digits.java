package calculator.service.digit;

import calculator.operation.Operation;
import calculator.service.calculations.Calculations;

public abstract class Digits {

    private final Calculations calculations;

    public Digits(Calculations calculations) {
        this.calculations = calculations;
    }

    public Digits() {
        this.calculations = new Calculations();
    }

    public abstract String exec(String a, String b, Operation operation);

    protected Calculations getCalculations() {
        return calculations;
    }
}
