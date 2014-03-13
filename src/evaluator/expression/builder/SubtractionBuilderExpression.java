package evaluator.expression.builder;

import parser.BuilderExpression;
import evaluator.Expression;
import evaluator.Subtraction;
import parser.Token;

public class SubtractionBuilderExpression implements BuilderExpression {
    
    private final Token.Symbol symbol = Token.symbol("-");
    
    @Override
    public Expression buildExpression(Expression left, Expression right) {
        return new Subtraction(left, right);
    }

    @Override
    public Token.Symbol getSymbol() {
        return symbol;
    }
    
}
