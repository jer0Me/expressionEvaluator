package evaluator.operators.addition;

import evaluator.operators.BinaryOperator;

public class IntegerDoubleAddition extends BinaryOperator{

    @Override
    public Object execute(Object left, Object right) {
        return (Integer) left + (double) right;
    }
    
    

}
