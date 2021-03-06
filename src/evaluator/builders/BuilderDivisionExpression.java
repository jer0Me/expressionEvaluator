package evaluator.builders;

import evaluator.BuilderExpression;
import evaluator.Division;
import evaluator.Expression;
import parser.Token;

public class BuilderDivisionExpression extends BuilderExpression {

    public BuilderDivisionExpression() {
        super(Token.symbol("/", 3, true));

    }

    @Override
    public Expression getExpression(Expression left, Expression right) {
        return new Division(left, right);
    }
    
}
