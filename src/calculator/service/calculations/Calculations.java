package calculator.service.calculations;

import calculator.operation.AddMathOperation;
import calculator.operation.MathOperation;
import calculator.operation.Operation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculations {

    private Map<Operation, MathOperation> operationToMathOperation = new HashMap<>();

    public Calculations() {
        operationToMathOperation.put(Operation.ADD, new AddMathOperation());
//        operationToMathOperation.put(Operation.ADD, new AddMathOperation());
//        operationToMathOperation.put(Operation.ADD, new AddMathOperation());
    }

    public int calculate(int firstTerm, int secondTerm, Operation operation) {
        return operationToMathOperation.get(operation)
                .execute(firstTerm, secondTerm);
    }
}