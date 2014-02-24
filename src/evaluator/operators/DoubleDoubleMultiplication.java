package evaluator.operators;

public class DoubleDoubleMultiplication extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Double) left * (Double) right;
    }

}
