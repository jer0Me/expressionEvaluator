package parser;

import evaluator.Expression;

public interface BuilderExpression {
        
    public Token.Symbol getSymbol();
    
    public Expression buildExpression(Expression left, Expression right);

}
