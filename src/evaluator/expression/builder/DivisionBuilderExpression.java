package evaluator.expression.builder;

import parser.BuilderExpression;
import evaluator.Division;
import evaluator.Expression;
import parser.Token;

public class DivisionBuilderExpression implements BuilderExpression {

    private final Token.Symbol symbol = Token.symbol("/");
    
    @Override
    public Expression buildExpression(Expression left, Expression right) {
        return new Division(left, right);
    }

    @Override
    public Token.Symbol getSymbol() {
        return symbol;
    }
    
}
