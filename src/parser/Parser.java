package parser;

import evaluator.Expression;
import java.util.List;
import java.util.Stack;

public abstract class Parser {
    protected final ParserStrategy parserStrategy;
    protected final Stack<SymbolToken> symbolStack;

    public abstract Expression parse(List<Token> tokens);

    public Parser(ParserStrategy parserStrategy) {
        this.parserStrategy = parserStrategy;
        this.symbolStack = new Stack<>();
    }
    
    
    
}
