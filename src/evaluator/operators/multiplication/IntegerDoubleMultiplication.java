package evaluator.operators.multiplication;

import evaluator.operators.BinaryOperator;

public class IntegerDoubleMultiplication extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Integer) left * (Double) right;
    }

}
