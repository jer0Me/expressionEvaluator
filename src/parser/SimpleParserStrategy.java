package parser;

import evaluator.Constant;
import evaluator.Expression;

public class SimpleParserStrategy extends ParserStrategy {
    
    @Override
    public void build(SymbolToken symbol)  {
            Expression right = expressions.pop();
            Expression left = expressions.pop();
            expressions.push(new ExpressionFactory().createExpression(symbol, left, right));
    }

    @Override
    public void build(ConstantToken constant) {
        expressions.push(new Constant(constant.getValue()));
    }
    
}