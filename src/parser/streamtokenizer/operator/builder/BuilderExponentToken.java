package parser.streamtokenizer.operator.builder;

import parser.Token;
import parser.streamtokenizer.StreamTokenizerBuilderOperatorToken;

public class BuilderExponentToken extends StreamTokenizerBuilderOperatorToken {

    public BuilderExponentToken() {
        super("^");
    }

    @Override
    public Token build() {
        return Token.symbol("^", 4, false);
    }
    
}
