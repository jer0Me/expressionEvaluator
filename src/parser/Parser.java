package parser;

import evaluator.Expression;
import evaluator.InvalidOperationException;
import java.util.Stack;

public class Parser {

    private final Stack<SymbolToken> symbols;
    private final ParserStrategy parserStrategy;

    public Parser(ParserStrategy parserStrategy) {
        symbols = new Stack<>();
        this.parserStrategy = parserStrategy;
    }

}