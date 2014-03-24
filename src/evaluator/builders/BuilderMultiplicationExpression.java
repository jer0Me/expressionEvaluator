package evaluator.builders;

import evaluator.BuilderExpression;
import evaluator.Expression;
import evaluator.Multiplication;
import parser.Token;

public class BuilderMultiplicationExpression extends BuilderExpression {

    public BuilderMultiplicationExpression() {
        super(Token.symbol("*", 3, true));
    }

    @Override
    public Expression getExpression(Expression left, Expression right) {
        return new Multiplication(left,right);
    }

}
