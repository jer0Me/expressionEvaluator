package parser;

public abstract class Token {

    public static <Type> ConstantToken constant(Type value) {
        return new ConstantToken(value);
    }

    public static SymbolToken symbol(String symbol) {
        return new SymbolToken(symbol);
    }
}
