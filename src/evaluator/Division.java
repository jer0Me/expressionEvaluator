package evaluator;

import evaluator.operators.BinaryOperator;

public class Division extends BinaryOperation {

    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected BinaryOperator createBinaryOperator(Object left, Object right) {
        return new BinaryOperatorFactory().createOperator("Division", left, right);
    }
    
}
