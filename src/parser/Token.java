package parser;

public abstract class Token {

    public static <Type> ConstantToken constant(Type value) {
        return new ConstantToken(value);
    }

    public static SymbolToken symbol(String symbol, Integer precedence, boolean leftAssociative) {
        return new SymbolToken(symbol, precedence, leftAssociative);
    }
    
}
