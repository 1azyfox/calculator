package calculator.service.digit.rome;

public enum RomeDigitCondition {
    I(73),V(86),X(88);

    private final int ascii;

    RomeDigitCondition(int ascii) {
        this.ascii = ascii;
    }

    public int getAscii() {
        return ascii;
    }
}
