package parser;

import evaluator.Constant;
import evaluator.Expression;

public class SimpleParserStrategy extends ParserStrategy {
    
    @Override
    public void build(Token.Constant constant) {
        expressions.push(new Constant(constant.getValue()));
    }

    @Override
    public void build(Token.Symbol symbol)  {
            Expression right = expressions.pop();
            Expression left = expressions.pop();
            expressions.push(new ExpressionFactory().createExpression(symbol, left, right));
    }
    
    
}