package evaluator.operators.multiplication;

import evaluator.operators.BinaryOperator;

public class DoubleIntegerMultiplication extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Double) left * (Integer) right;
    }

}
