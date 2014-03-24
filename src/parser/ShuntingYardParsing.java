package parser;

import evaluator.Expression;

public class ShuntingYardParsing extends Parser {

    public ShuntingYardParsing(ParserStrategy parserStrategy) {
        super(parserStrategy);
    }

    @Override
    public Expression parse(Token[] tokens) {
        processTokens(tokens);
        processStackSymbols();
        return parserStrategy.getExpression();
    }

    private boolean checkLeftPrecedenceRule(SymbolToken symbol, SymbolToken topSymbolStack) {
        return symbol.isLeftAssociative() && (symbol.getPrecedence() > topSymbolStack.getPrecedence());
    }

    private boolean checkRightPrecedenceRule(SymbolToken symbol, SymbolToken topSymbolStack) {
        return !symbol.isLeftAssociative() && (symbol.getPrecedence() <= topSymbolStack.getPrecedence());
    }

    private boolean checkPrecedencesRule(SymbolToken symbol) {
        return (checkLeftPrecedenceRule(symbol, symbolStack.peek()))
                || checkRightPrecedenceRule(symbol, symbolStack.peek());
    }

    private boolean isLeftBreakSymbol(SymbolToken symbol) {
        return symbol.equals(new SymbolToken("(", -1, true));
    }

    private boolean isRightBreakSymbol(SymbolToken token) {
        return token.equals(new SymbolToken(")", -1, true));
    }

    private void processStackSymbols() {
        while (symbolStack.size() > 0) {
            parserStrategy.build(symbolStack.pop());
        }
    }

    private boolean isConstant(Token token) {
        return token instanceof ConstantToken;
    }

    private void prepareSymbolStackBeforeInsertion(Token token) {
        while (!checkPrecedencesRule((SymbolToken) token)) {
            parserStrategy.build(symbolStack.pop());
        }
    }

    private void processRightBreakSymbol() {
        if (symbolStack.size() > 0) {
            while (!isLeftBreakSymbol(symbolStack.peek())) {
            parserStrategy.build(symbolStack.pop());
            }
            symbolStack.pop();
        }
    }

    private void processSymbol(SymbolToken symbol) {
        checkLeftBreakSymbol(symbol);
        checkRightBreakSymbol(symbol);
        prepareSymbolStackBeforeInsertion(symbol);
        symbolStack.push(symbol);
    }

    private void processConstant(ConstantToken constant) {
        parserStrategy.build(constant);
    }

    private void processToken(Token token) {
        if (isConstant(token)) {
            processConstant((ConstantToken)token);
        } else {
            processSymbol((SymbolToken) token);
        }
    }

    private void processTokens(Token[] tokens) {
        for (Token token : tokens) {
            processToken(token);
        }
    }

    private void checkLeftBreakSymbol(SymbolToken symbol) {
        if (isLeftBreakSymbol(symbol)){
            symbolStack.push(symbol);
        }
    }

    private void checkRightBreakSymbol(SymbolToken symbol) {
        if (isRightBreakSymbol(symbol)){
            processRightBreakSymbol();
        }
    }
}
