package parser.streamtokenizer.operator.builder;

import parser.Token;
import parser.streamtokenizer.StreamTokenizerBuilderOperatorToken;

public class BuilderSubtractionToken extends StreamTokenizerBuilderOperatorToken {

    public BuilderSubtractionToken() {
        super("-");
    }

    @Override
    public Token build() {
        return Token.symbol("-", 2, true);
    }
    
}
