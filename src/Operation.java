public enum Operation {
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/');

    private final char operationSymbol;

    Operation(char operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public char getOperationSymbol() {
        return operationSymbol;
    }
}
