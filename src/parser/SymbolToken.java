package parser;

import java.util.Objects;

public class SymbolToken extends Token {

    private final String token;
    private final int precedence;
    private final boolean leftAssociative;
    
    public SymbolToken(String token, Integer precedence, boolean leftAssociative) {
        this.token = token;
        this.precedence = precedence;
        this.leftAssociative = leftAssociative;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SymbolToken other = (SymbolToken) obj;
        if (!Objects.equals(this.token, other.token)) {
            return false;
        }
        return true;
    }
    
}
