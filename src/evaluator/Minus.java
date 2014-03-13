package evaluator;

import evaluator.operators.UnaryOperator;

public class Minus extends UnaryOperation {

    public Minus(Expression expression) {
        super(expression);
    }

    @Override
    protected UnaryOperator createUnaryOperator(Object expression) {
        return new UnaryOperatorFactory().createOperator("Minus", expression);
    }
    
}
