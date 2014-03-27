package evaluator.builders;

import evaluator.BuilderExpression;
import evaluator.Expression;
import evaluator.Pow;
import parser.Token;

public class BuilderPowExpression extends BuilderExpression {

    public BuilderPowExpression() {
        super(Token.symbol("^", 4, false));
    }

    @Override
    public Expression getExpression(Expression left, Expression right) {
        return new Pow(left, right);
    }

}
