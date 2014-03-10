package parser;

import evaluator.Expression;
import java.util.Stack;

public abstract class ParserStrategy {

    private final Stack<Expression> expressions;

    public ParserStrategy() {
        expressions = new Stack();
    }

    public abstract void build(Token.Constant constant);

    public abstract void build(Token.Symbol symbol);

    public Expression getExpression() {
        if (expressions.size() > 0) {
            return expressions.peek();
        }
        return null;
    }
}
