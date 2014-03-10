package evaluator.operators.division;

import evaluator.operators.BinaryOperator;

public class IntegerDoubleDivision extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Integer)left / (Double)right;
    }
    
}
