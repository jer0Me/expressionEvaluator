package evaluator.operators.addition;

import evaluator.operators.BinaryOperator;


public class DoubleDoubleAddition extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Double) left + (Double) right;
    }
    

}
