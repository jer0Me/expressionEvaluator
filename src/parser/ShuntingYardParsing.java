package parser;

import evaluator.Expression;
import java.util.List;

public class ShuntingYardParsing extends Parser {

    public ShuntingYardParsing(ParserStrategy parserStrategy) {
        super(parserStrategy);
    }

    @Override
    public Expression parse(List<Token> tokens) {
        processTokens(tokens);
        processStackSymbols();
        return parserStrategy.getExpression();
    }

    private boolean checkLeftPrecedenceRule(SymbolToken symbol) {
        return symbol.isLeftAssociative() && 
                (symbol.getPrecedence() > symbolStack.peek().getPrecedence());
    }

    private boolean checkRightPrecedenceRule(SymbolToken symbol) {
        return !symbol.isLeftAssociative() && 
                (symbol.getPrecedence() <= symbolStack.peek().getPrecedence());
    }

    private boolean checkPrecedencesRule(SymbolToken symbol) {
        return checkLeftPrecedenceRule(symbol) || checkRightPrecedenceRule(symbol);
    }

    private boolean isLeftBreakSymbol(SymbolToken symbol) {
        return symbol.equals(new SymbolToken("(", -1, true));
    }

    private boolean isRightBreakSymbol(SymbolToken token) {
        return token.equals(new SymbolToken(")", -1, true));
    }

    private void processStackSymbols() {
        while (!symbolStack.empty()) {
            parserStrategy.build(symbolStack.pop());
        }
    }

    private boolean isConstant(Token token) {
        return token instanceof ConstantToken;
    }

    private void prepareSymbolStackBeforeInsertion(Token token) {
            while (!symbolStack.empty() && !checkPrecedencesRule((SymbolToken) token)) {
                parserStrategy.build(symbolStack.pop());
            }
    }

    private void processRightBreakSymbol() {
        if (!symbolStack.empty()) {
            while (!isLeftBreakSymbol(symbolStack.peek())) {
                parserStrategy.build(symbolStack.pop());
            }
            symbolStack.pop();
        }
    }

    private void processSymbol(SymbolToken symbol) {
        if (checkAndProcessBreakCase(symbol)) {
            return;
        }
        prepareSymbolStackBeforeInsertion(symbol);
        symbolStack.push(symbol);
    }

    private boolean checkAndProcessBreakCase(SymbolToken symbol) {
        return checkLeftBreakSymbol(symbol) || checkRightBreakSymbol(symbol);
    }

    private void processConstant(ConstantToken constant) {
        parserStrategy.build(constant);
    }

    private void processToken(Token token) {
        if (isConstant(token)) {
            processConstant((ConstantToken) token);
        } else {
            processSymbol((SymbolToken) token);
        }
    }

    private void processTokens(List<Token> tokenList) {
        for (Token token : tokenList) {
            processToken(token);
        }
    }

    private boolean checkLeftBreakSymbol(SymbolToken symbol) {
        if (isLeftBreakSymbol(symbol)) {
            symbolStack.push(symbol);
            return true;
        }
        return false;
    }

    private boolean checkRightBreakSymbol(SymbolToken symbol) {
        if (isRightBreakSymbol(symbol)) {
            processRightBreakSymbol();
            return true;
        }
        return false;
    }
}
