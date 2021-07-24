package calculator.operation;

public class AddMathOperation implements MathOperation {
    @Override
    public int execute(int x, int y) {
        return x + y;
    }
}
