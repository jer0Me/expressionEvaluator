package evaluator;

import evaluator.operators.BinaryOperator;

public class Subtraction extends BinaryOperation {

    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected BinaryOperator createBinaryOperator(Object left, Object right) {
        return new OperatorFactory().createOperator("Subtraction", left, right);
    }
    
}
