package parser;

import java.util.Objects;

public class ConstantToken<Type> extends Token {
    
    private final Type value;

    ConstantToken(Type value) {
        this.value = value;
    }

    public Type getValue() {
        return value;
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
        final ConstantToken<Type> other = (ConstantToken<Type>) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }
    
}
