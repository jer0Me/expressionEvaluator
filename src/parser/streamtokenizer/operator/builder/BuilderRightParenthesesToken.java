package parser.streamtokenizer.operator.builder;

import parser.Token;
import parser.streamtokenizer.StreamTokenizerBuilderOperatorToken;

public class BuilderRightParenthesesToken extends StreamTokenizerBuilderOperatorToken {

    public BuilderRightParenthesesToken() {
        super(")");
    }

    @Override
    public Token build() {
        return Token.symbol(")", -1, true);
    }
    
}
