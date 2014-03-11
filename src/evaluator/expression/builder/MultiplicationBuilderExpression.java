package evaluator.expression.builder;

import parser.BuilderExpression;
import evaluator.Expression;
import evaluator.Multiplication;

public class MultiplicationBuilderExpression implements BuilderExpression {

    private final String symbol = "*";
    
    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Expression buildExpression(Expression left, Expression right) {
        return new Multiplication(left, right);
    }
    
}
