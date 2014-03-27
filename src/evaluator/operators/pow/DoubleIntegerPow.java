package evaluator.operators.pow;

import evaluator.operators.BinaryOperator;

public class DoubleIntegerPow extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return Math.pow((Double) left, (Integer) right);
    }   
}
