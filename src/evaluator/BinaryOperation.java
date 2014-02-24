package evaluator;

import evaluator.operators.BinaryOperator;

public abstract class BinaryOperation implements Expression {
    private final Expression left;
    private final Expression right;

    public BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    protected abstract BinaryOperator createBinaryOperator(Object left, Object right);

    @Override
    public Object evaluate() {
        return evaluate(left.evaluate(), right.evaluate());
    }

    protected Object evaluate(Object left, Object right) {
        return createBinaryOperator(left, right).execute(left, right);
    }
    
}
