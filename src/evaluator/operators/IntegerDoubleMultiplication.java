package evaluator.operators;

public class IntegerDoubleMultiplication extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Integer) left * (Double) right;
    }

}
