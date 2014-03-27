package parser.streamtokenizer.operator.builder;

import parser.Token;
import parser.streamtokenizer.StreamTokenizerBuilderOperatorToken;

public class BuilderMultiplicationToken extends StreamTokenizerBuilderOperatorToken {

    public BuilderMultiplicationToken() {
        super("*");
    }

    @Override
    public Token build() {
        return Token.symbol("*", 3, true);
    }
    
}
