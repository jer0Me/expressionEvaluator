package parser.streamtokenizer;

import java.io.StreamTokenizer;
import parser.Token;

public class StreamTokenizerOperatorToken implements StreamTokenizerTypeToken {

    @Override
    public Token getToken(StreamTokenizer tokenizer) {
        return new StreamTokenizerOperatorTokenFactory().getToken(tokenizer);
    }

}
