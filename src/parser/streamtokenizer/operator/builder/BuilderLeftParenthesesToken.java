package parser.streamtokenizer.operator.builder;

import parser.Token;
import parser.streamtokenizer.StreamTokenizerBuilderOperatorToken;

public class BuilderLeftParenthesesToken extends StreamTokenizerBuilderOperatorToken {

    public BuilderLeftParenthesesToken() {
        super("(");
    }

    @Override
    public Token build() {
        return Token.symbol("(", -1, true);
    }
    
}
