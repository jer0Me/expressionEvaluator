package evaluator.expression.builder;

import parser.BuilderExpression;
import evaluator.Addition;
import evaluator.Expression;
import parser.Token;

public class AdditionBuilderExpression implements BuilderExpression {

    private final Token.Symbol symbol = Token.symbol("+");

    @Override
    public Expression buildExpression(Expression left, Expression right) {
        return new Addition(left, right);
    }

    @Override
    public Token.Symbol getSymbol() {
        return symbol;
    }
    
}
