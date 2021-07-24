package calculator.dto;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsertDto insertDto = (InsertDto) o;

        if (firstTerm != null ? !firstTerm.equals(insertDto.firstTerm) : insertDto.firstTerm != null) return false;
        if (operation != null ? !operation.equals(insertDto.operation) : insertDto.operation != null) return false;
        return secondTerm != null ? secondTerm.equals(insertDto.secondTerm) : insertDto.secondTerm == null;
    }

    @Override
    public int hashCode() {
        int result = firstTerm != null ? firstTerm.hashCode() : 0;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (secondTerm != null ? secondTerm.hashCode() : 0);
        return result;
    }
}
