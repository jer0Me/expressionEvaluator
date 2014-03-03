package parser;

import evaluator.Expression;
import java.util.Stack;

public class Parser {

    private final Stack<Token.Symbol> symbols;
    private final Stack<Expression> expressions;
    private final ExpressionFactory expressionFactory;

    public Parser(ExpressionFactory expressionFactory) {
        symbols = new Stack<>();
        expressions = new Stack<>();
        this.expressionFactory = expressionFactory;
    }
    
    //TODO
    public Expression parse (Token[] tokens) {
        
        return null;
        
      
        
    }
    
    private void parse (Token token) {
        
    }
    
    private void process (Token.Symbol symbol) {
        
    }
}
