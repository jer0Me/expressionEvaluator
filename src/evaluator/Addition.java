package evaluator;

import evaluator.operators.BinaryOperator;

public class Addition extends BinaryOperation {

    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected BinaryOperator createBinaryOperator(Object left, Object right) {
        return new OperatorFactory().createOperator("Addition", left, right);

    }
}
