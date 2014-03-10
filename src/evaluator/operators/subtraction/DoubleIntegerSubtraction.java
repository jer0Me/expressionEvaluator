package evaluator.operators.subtraction;

import evaluator.operators.BinaryOperator;

public class DoubleIntegerSubtraction extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Double)left - (Integer)right;
    }
    
}
