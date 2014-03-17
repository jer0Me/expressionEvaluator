package evaluator;

import parser.SymbolToken;
import parser.Token;

public abstract class BuilderExpression {

    protected final SymbolToken type;

    public BuilderExpression(SymbolToken type) {
        this.type = type;
    }

    public SymbolToken getType() {
        return type;
    }
    
    public abstract Expression getExpression(Expression left, Expression right);
  
}
