package parser.streamtokenizer.operator.builder;

import parser.Token;
import parser.streamtokenizer.StreamTokenizerBuilderOperatorToken;

public class BuilderAdditionToken extends StreamTokenizerBuilderOperatorToken {

    public BuilderAdditionToken() {
        super("+");
    }

    @Override
    public Token build() {
        return Token.symbol("+", 2, true);
    }
    
}
