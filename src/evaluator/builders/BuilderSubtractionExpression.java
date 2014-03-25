package evaluator.builders;

import evaluator.BuilderExpression;
import evaluator.Expression;
import evaluator.Subtraction;
import parser.Token;

public class BuilderSubtractionExpression extends BuilderExpression {

    public BuilderSubtractionExpression() {
        super(Token.symbol("-", 2, true));
    }

    @Override
    public Expression getExpression(Expression left, Expression right) {
        return new Subtraction(left, right);
    }
    
}
