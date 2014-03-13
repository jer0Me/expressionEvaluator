package evaluator;

import evaluator.operators.BinaryOperator;

public class Multiplication extends BinaryOperation {

    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected BinaryOperator createBinaryOperator(Object left, Object right) {
        return new BinaryOperatorFactory().createOperator("Multiplication", left, right);
    }

}
