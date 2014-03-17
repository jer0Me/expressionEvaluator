package evaluator.builders;

import evaluator.BuilderExpression;
import evaluator.Expression;
import evaluator.Multiplication;
import parser.SymbolToken;

public class BuilderMultiplicationExpression extends BuilderExpression {

    public BuilderMultiplicationExpression(SymbolToken symbol) {
        super(symbol);
    }

    @Override
    public Expression getExpression(Expression left, Expression right) {
        return new Multiplication(left,right);
    }

}
