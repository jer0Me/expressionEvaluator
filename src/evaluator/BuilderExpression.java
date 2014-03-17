package evaluator;

import parser.SymbolToken;

public abstract class BuilderExpression {

    protected static SymbolToken symbol;

    public BuilderExpression(SymbolToken symbol) {
        BuilderExpression.symbol = symbol;
    }

    public static SymbolToken getSymbol() {
        return symbol;
    }

    public abstract Expression getExpression(Expression left, Expression right);
  
}
