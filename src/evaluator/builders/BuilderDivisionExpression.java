package evaluator.builders;

import evaluator.BuilderExpression;
import evaluator.Division;
import evaluator.Expression;
import parser.SymbolToken;

public class BuilderDivisionExpression extends BuilderExpression {

    public BuilderDivisionExpression(SymbolToken symbol) {
        super(symbol);
    }

    @Override
    public Expression getExpression(Expression left, Expression right) {
        return new Division(left, right);
    }
    
}
