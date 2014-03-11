package parser;

import evaluator.Constant;
import evaluator.Expression;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleParserStrategy extends ParserStrategy {
    
    @Override
    public void build(Token.Constant constant) {
        expressions.push(new Constant(constant.getValue()));
    }

    @Override
    public void build(Token.Symbol symbol)  {
        try {
            Expression right = expressions.pop();
            Expression left = expressions.pop();
            expressions.push(new ExpressionFactory().createExpression(symbol, left, right));
        } catch (InstantiationException | IllegalAccessException  ex) {
            Logger.getLogger(SimpleParserStrategy.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}