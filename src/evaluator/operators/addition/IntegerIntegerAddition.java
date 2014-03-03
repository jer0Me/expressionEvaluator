package evaluator.operators.addition;

import evaluator.operators.BinaryOperator;

public class IntegerIntegerAddition extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Integer) left + (Integer) right;
    }
    
    
}
