package evaluator.expression.builder;

import parser.BuilderExpression;
import evaluator.Expression;
import evaluator.Multiplication;
import parser.Token;

public class MultiplicationBuilderExpression implements BuilderExpression {

    private final Token.Symbol symbol = Token.symbol("*");
    
    @Override
    public Expression buildExpression(Expression left, Expression right) {
        return new Multiplication(left, right);
    }

    @Override
    public Token.Symbol getSymbol() {
        return symbol;
    }
    
}
