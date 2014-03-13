package evaluator;

import evaluator.Expression;
import evaluator.operators.UnaryOperator;

public abstract class UnaryOperation implements Expression {

    private final Expression expression;

    public UnaryOperation(Expression expression) {
        this.expression = expression;
    }
    
    protected abstract UnaryOperator createUnaryOperator(Object expression);

    @Override
    public Object evaluate() {
        return evaluate(expression.evaluate());
    }

    protected Object evaluate(Object expression) {
        return createUnaryOperator(expression).execute(expression);
    }

}