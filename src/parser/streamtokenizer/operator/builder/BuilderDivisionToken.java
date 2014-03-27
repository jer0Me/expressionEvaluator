package parser.streamtokenizer.operator.builder;

import parser.Token;
import parser.streamtokenizer.StreamTokenizerBuilderOperatorToken;

public class BuilderDivisionToken extends StreamTokenizerBuilderOperatorToken {

    public BuilderDivisionToken() {
        super("/");
    }

    @Override
    public Token build() {
        return Token.symbol("/", 3, true);
    }
    
}
