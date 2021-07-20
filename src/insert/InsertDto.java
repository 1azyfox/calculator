package insert;

public class InsertDto {
    private final String firstTerm;
    private final String operation;
    private final String secondTerm;

    public InsertDto(String firstTerm, String operation, String secondTerm) {
        this.firstTerm = firstTerm;
        this.operation = operation;
        this.secondTerm = secondTerm;
    }

    public String getFirstTerm() {
        return firstTerm;
    }

    public String getOperation() {
        return operation;
    }

    public String getSecondTerm() {
        return secondTerm;
    }
}
