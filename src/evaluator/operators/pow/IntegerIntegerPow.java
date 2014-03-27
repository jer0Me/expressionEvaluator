package evaluator.operators.pow;

import evaluator.operators.BinaryOperator;

public class IntegerIntegerPow extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return Math.pow((Integer) left, (Integer) right);
    }
}
