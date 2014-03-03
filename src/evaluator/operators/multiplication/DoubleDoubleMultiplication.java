package evaluator.operators.multiplication;

import evaluator.operators.BinaryOperator;

public class DoubleDoubleMultiplication extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Double) left * (Double) right;
    }

}
