package evaluator.operators.subtraction;

import evaluator.operators.BinaryOperator;

public class IntegerDoubleSubtraction extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Integer)left - (Double)right;
    }
        
}
