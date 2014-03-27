package parser.streamtokenizer;

import parser.Token;

public abstract class StreamTokenizerBuilderOperatorToken {
    
    protected final String operator;

    public StreamTokenizerBuilderOperatorToken(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public abstract Token build();
    
}
