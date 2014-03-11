package evaluator.expression.builder;

import parser.BuilderExpression;
import evaluator.Division;
import evaluator.Expression;

public class DivisionBuilderExpression implements BuilderExpression {

    private final String symbol = "/";
    
    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Expression buildExpression(Expression left, Expression right) {
        return new Division(left, right);
    }
    
}
