package evaluator;

import parser.SymbolToken;

public abstract class BuilderExpression {

    protected final SymbolToken symbol;

    public BuilderExpression(SymbolToken symbol) {
        this.symbol = symbol;
    }

    public final SymbolToken getSymbol() {
        return symbol;
    }

    public abstract Expression getExpression(Expression left, Expression right);
  
}
