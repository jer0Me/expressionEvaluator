package parser;

import evaluator.Expression;

public interface BuilderExpression {
        
    public String getSymbol();
    
    public Expression buildExpression(Expression left, Expression right);

}
