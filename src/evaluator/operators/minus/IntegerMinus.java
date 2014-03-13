package evaluator.operators.minus;

import evaluator.operators.UnaryOperator;

public class IntegerMinus implements UnaryOperator {

    @Override
    public Object execute(Object expression) {
        return -(Integer)expression;
    }


    
}
