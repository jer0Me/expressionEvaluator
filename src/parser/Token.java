package parser;

import java.util.Objects;

public abstract class Token {

    public static <Type> Constant constant(Type value) {
        return new Constant(value);
    }

    public static Symbol symbol(String symbol) {
        return new Symbol(symbol);
    }

    public static class Constant<Type> extends Token {

        private final Type value;

        private Constant(Type value) {
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
            final Constant<Type> other = (Constant<Type>) obj;
            if (!Objects.equals(this.value, other.value)) {
                return false;
            }
            return true;
        }
    }

    public static class Symbol extends Token {

        private final String token;

        public Symbol(String token) {
            this.token = token;
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
            final Symbol other = (Symbol) obj;
            if (!Objects.equals(this.token, other.token)) {
                return false;
            }
            return true;
        }
    }
}
