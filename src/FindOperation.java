public class FindOperation {
    public static int getOperationNumber(String operation) {
        int operationNumber = 0;
        char[] operationInArray = operation.toCharArray();
        if (operationInArray.length == 1) {
            if (operationInArray[0] == Operation.ADD.getOperationSymbol()) {
                operationNumber = Operation.ADD.ordinal();
            } else {
                if (operationInArray[0] == Operation.SUBTRACT.getOperationSymbol()) {
                    operationNumber = Operation.SUBTRACT.ordinal();
                } else {
                    if (operationInArray[0] == Operation.MULTIPLY.getOperationSymbol()) {
                        operationNumber = Operation.MULTIPLY.ordinal();
                    } else {
                        if (operationInArray[0] == Operation.DIVIDE.getOperationSymbol()) {
                            operationNumber = Operation.DIVIDE.ordinal();
                        }
                    }
                }
            }
        }
        return operationNumber;
    }

    public static int findNumberInArray(int[] inArray, int needFind) {
        for (int i = 0; i < inArray.length; i++) {
            if (needFind == inArray[i]) {
                return i + 1;
            }
        }
        return 0;
    }
}

