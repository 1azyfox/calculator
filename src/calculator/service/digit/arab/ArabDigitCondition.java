package calculator.service.digit.arab;

public enum ArabDigitCondition {
    MIN_ARAB_DIGIT(1), MAX_ARAB_DIGIT(10);

    private final int value;

    ArabDigitCondition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
