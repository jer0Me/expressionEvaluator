package parser;

import evaluator.Addition;
import evaluator.Division;
import evaluator.Expression;
import evaluator.Multiplication;
import evaluator.Subtraction;

public class ExpressionFactory {

    public Expression createExpression(Token.Symbol symbol, Expression left, Expression right) {
        if(symbol.equals("+")) return new Addition(left,right);
        if(symbol.equals("-")) return new Subtraction(left,right);
        if(symbol.equals("*")) return new Multiplication(left, right);
        if(symbol.equals("/")) return new Division(left,right);
        return null;
    }
    
}
