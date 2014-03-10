package evaluator.operators.division;

import evaluator.operators.BinaryOperator;

public class IntegerIntegerDivision extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Integer)left / (Integer)right;
    }
    
}
