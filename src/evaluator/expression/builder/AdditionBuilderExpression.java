package evaluator.expression.builder;

import parser.BuilderExpression;
import evaluator.Addition;
import evaluator.Expression;

public class AdditionBuilderExpression implements BuilderExpression {

    private final String symbol = "+";

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Expression buildExpression(Expression left, Expression right) {
        return new Addition(left, right);
    }
    
}
