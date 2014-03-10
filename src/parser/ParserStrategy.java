package parser;

import evaluator.Expression;
import java.util.Stack;

public abstract class ParserStrategy {

    protected final Stack<Expression> expressions;

    public ParserStrategy() {
        expressions = new Stack();
    }

    public abstract void build(Token.Constant constant);

    public abstract void build(Token.Symbol symbol);

    public Expression getExpression() {
        return expressions.peek();
    }
}
