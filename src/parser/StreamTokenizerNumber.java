package parser;

import java.io.StreamTokenizer;

public class StreamTokenizerNumber implements StreamTokenizerType {

    @Override
    public Token getToken(StreamTokenizer tokenizer) {
        return Token.constant(tokenizer.nval);
    }
    
}
