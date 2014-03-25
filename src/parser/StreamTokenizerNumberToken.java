package parser;

import java.io.StreamTokenizer;

public class StreamTokenizerNumberToken implements StreamTokenizerTypeToken {

    @Override
    public Token getToken(StreamTokenizer tokenizer) {
        return Token.constant(tokenizer.nval);
    }
    
}
