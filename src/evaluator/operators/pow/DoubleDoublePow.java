package evaluator.operators.pow;

import evaluator.operators.BinaryOperator;

public class DoubleDoublePow extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return Math.pow((Double) left, (Double) right);
    }
}
