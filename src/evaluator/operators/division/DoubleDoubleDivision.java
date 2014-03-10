package evaluator.operators.division;

import evaluator.operators.BinaryOperator;

public class DoubleDoubleDivision extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Double)left / (Double)right;
    }
    
}
