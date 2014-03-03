package evaluator.operators.addition;

import evaluator.operators.BinaryOperator;

public class DoubleIntegerAddition extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Double) left + (Integer) right;
    }


}
