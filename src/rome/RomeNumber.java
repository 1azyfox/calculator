package rome;

public enum RomeNumber {
    I(73), II(146), III(219), IV(159), V(86), VI(159), VII(232), VIII(305), IX(161), X(88);

    private final int asciiSum;

    RomeNumber(int asciiSum) {
        this.asciiSum = asciiSum;
    }

    public int getAsciiSum() {
        return asciiSum;
    }
}
