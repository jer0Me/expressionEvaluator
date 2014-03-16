package evaluator;

import parser.Token;

public abstract class BuilderExpression {

    protected final Token.Symbol type;

    public BuilderExpression(Token.Symbol type) {
        this.type = type;
    }

    public Token.Symbol getType() {
        return type;
    }
    
    public abstract Expression getExpression(Expression left, Expression right);
  
}
