package parser;

import java.io.StreamTokenizer;
import parser.Token;

public abstract class StreamTokenizerBuilderOperatorToken {
    
    protected final String operator;

    public StreamTokenizerBuilderOperatorToken(String operator) {
        this.operator = operator;
    }
    
    public abstract Token build(StreamTokenizer tokenizer);
    
}
