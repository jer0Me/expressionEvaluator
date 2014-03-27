package evaluator;

import evaluator.operators.BinaryOperator;

public class Pow extends BinaryOperation {

    public Pow(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected BinaryOperator createBinaryOperator(Object left, Object right) {
        return new BinaryOperatorFactory().createOperator("Pow", left, right);
    }
    
}