package parser.streamtokenizer;

import java.io.StreamTokenizer;
import parser.Token;

public interface StreamTokenizerTypeToken {
    
    public Token getToken(StreamTokenizer tokenizer);
    
}
