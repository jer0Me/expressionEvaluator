package evaluator.operators;

public class IntegerIntegerMultiplication extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Integer) left * (Integer) right;
    }

}
