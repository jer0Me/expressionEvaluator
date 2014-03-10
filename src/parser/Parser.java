package parser;

import evaluator.Expression;
import java.util.Stack;

public class Parser {

    private final Stack<Token.Symbol> symbols;
    private final ParserStrategy parserStrategy;

    public Parser(ParserStrategy parserStrategy) {
        symbols = new Stack<>();
        this.parserStrategy = parserStrategy;
    }

    //TODO
    public Expression parse(Token[] tokens) {
        for (Token token : tokens) {
            if (token instanceof Token.Constant) {
                parserStrategy.build((Token.Constant) token);
            }
            if (token instanceof Token.Symbol) {
                if (symbols.size() > 0) {
                    if (((Token.Symbol) token).equals(new Token.Symbol(")"))) {
                        processBreak();
                        continue;
                    }
                    if (hasLessPrecedence(token)) {
                        parserStrategy.build((Token.Symbol) token);
                    }
                }
                symbols.push((Token.Symbol) token);
            }
        }
        while (symbols.size()>0) {
            parserStrategy.build(symbols.pop());
        }
        return parserStrategy.getExpression();
    }

    // Todo
    private boolean hasLessPrecedence(Token token) {
        return false;
        
    }

    private void processBreak() {
        while (!symbols.peek().equals(new Token.Symbol("("))){
            parserStrategy.build(symbols.pop());
        }
        symbols.pop();
    }
}
