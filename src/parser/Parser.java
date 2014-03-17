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

    public Expression parse(Token[] tokens) {
        for (Token token : tokens) {
            if (token instanceof ConstantToken) {
                parserStrategy.build((ConstantToken) token);
            }
            if (token instanceof SymbolToken) {
                if (symbols.size() > 0) {
                    if (((SymbolToken) token).equals(new SymbolToken(")"))) {
                        processBreak();
                        continue;
                    }
                    while (!checkPrecedenceRule((SymbolToken) token)) {
                        parserStrategy.build(symbols.pop());
                    }
                }
                symbols.push((SymbolToken) token);
            }
        }
        while (symbols.size() > 0) {
            parserStrategy.build(symbols.pop());
        }
        return parserStrategy.getExpression();
    }

    private int operatorPrecedence(SymbolToken symbol) {
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

    private boolean isLeftAssociative(SymbolToken symbol) {
        if (symbol.equals(Token.symbol("^"))) {
            return false;
        }
        return true;
    }

    private boolean isRightAssociative(SymbolToken symbol) {
        if (symbol.equals(Token.symbol("^"))) {
            return true;
        }
        return false;
    }

    private boolean checkPrecedenceRule(SymbolToken symbol) {
        SymbolToken topSymbolStack = symbols.peek();
        return (isLeftAssociative(symbol) && (operatorPrecedence(symbol) > operatorPrecedence(topSymbolStack)))
                || (isRightAssociative(symbol) && (operatorPrecedence(symbol) >= operatorPrecedence(topSymbolStack)));
    }

    private void processBreak() {
        while (!symbols.peek().equals(new SymbolToken("("))) {
            parserStrategy.build(symbols.pop());
        }
        symbols.pop();
    }
}
