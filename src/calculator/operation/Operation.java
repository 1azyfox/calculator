package calculator.operation;

public enum Operation {
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/');

    private final char operationSymbol;

    Operation(char operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public static Operation findBySymbol(String symbol) {
        for (Operation operation : Operation.values()) {
            if (String.valueOf(operation.operationSymbol).equals(symbol)) {
                return operation;
            }
        }
        throw new RuntimeException();
    }

    public char getOperationSymbol() {
        return operationSymbol;
    }
}
