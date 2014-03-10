package parser;

import evaluator.Expression;
import evaluator.InvalidOperationException;
import java.util.Stack;

public class Parser {

    private final Stack<Token.Symbol> symbols;
    private final ParserStrategy parserStrategy;

    public Parser(ParserStrategy parserStrategy) {
        symbols = new Stack<>();
        this.parserStrategy = parserStrategy;
    }

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
                    while (!checkPrecedenceRule((Token.Symbol) token)) {
                        parserStrategy.build(symbols.pop());
                    }
                }
                symbols.push((Token.Symbol) token);
            }
        }
        while (symbols.size() > 0) {
            parserStrategy.build(symbols.pop());
        }
        return parserStrategy.getExpression();
    }

    private int operatorPrecedence(Token.Symbol symbol) {
        if (symbol.equals(Token.symbol("+")) || symbol.equals(Token.symbol("-"))) {
            return 2;
        }
        if (symbol.equals(Token.symbol("/")) || symbol.equals(Token.symbol("*"))) {
            return 3;
        }
        if (symbol.equals(Token.symbol("^"))) {
            return 4;
        }
        throw new InvalidOperationException();
    }

    private boolean isLeftAssociative(Token.Symbol symbol) {
        if (symbol.equals(Token.symbol("^"))) {
            return false;
        }
        return true;
    }

    private boolean isRightAssociative(Token.Symbol symbol) {
        if (symbol.equals(Token.symbol("^"))) {
            return true;
        }
        return false;
    }

    private boolean checkPrecedenceRule(Token.Symbol symbol) {
        Token.Symbol topSymbolStack = symbols.peek();
        return (isLeftAssociative(symbol) && (operatorPrecedence(symbol) > operatorPrecedence(topSymbolStack)))
                || (isRightAssociative(symbol) && (operatorPrecedence(symbol) >= operatorPrecedence(topSymbolStack)));
    }

    private void processBreak() {
        while (!symbols.peek().equals(new Token.Symbol("("))) {
            parserStrategy.build(symbols.pop());
        }
        symbols.pop();
    }
}
