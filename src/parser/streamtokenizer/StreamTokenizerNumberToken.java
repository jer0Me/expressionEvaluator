package parser.streamtokenizer;

import java.io.StreamTokenizer;
import parser.Token;

public class StreamTokenizerNumberToken implements StreamTokenizerTypeToken {

    @Override
    public Token getToken(StreamTokenizer tokenizer) {
        return Token.constant(tokenizer.nval);
    }
    
}
