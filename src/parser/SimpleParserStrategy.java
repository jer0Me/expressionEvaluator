package parser;

import evaluator.Addition;
import evaluator.Constant;
import evaluator.Division;
import evaluator.Expression;
import evaluator.Multiplication;
import evaluator.Subtraction;

public class SimpleParserStrategy extends ParserStrategy {
    
    @Override
    public void build(Token.Constant constant) {
        expressions.push(new Constant(constant.getValue()));
    }

    @Override
    public void build(Token.Symbol symbol) {
        Expression right = expressions.pop();
        Expression left = expressions.pop();
        if(symbol.equals("+")) expressions.push(new Addition(left,right));
        if(symbol.equals("-")) expressions.push(new Subtraction(left,right));
        if(symbol.equals("*")) expressions.push(new Multiplication(left, right));
        if(symbol.equals("/")) expressions.push(new Division(left,right));
    }
}
