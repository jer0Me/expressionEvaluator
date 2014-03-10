package evaluator.operators.division;

import evaluator.operators.BinaryOperator;

public class DoubleIntegerDivision extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Double)left / (Integer)right;
    }
    
}
