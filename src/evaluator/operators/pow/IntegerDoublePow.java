package evaluator.operators.pow;

import evaluator.operators.BinaryOperator;

public class IntegerDoublePow extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return Math.pow((Integer) left, (Double) right);
    }
}
