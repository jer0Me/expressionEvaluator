package evaluator.operators.multiplication;

import evaluator.operators.BinaryOperator;

public class IntegerIntegerMultiplication extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Integer) left * (Integer) right;
    }

}
