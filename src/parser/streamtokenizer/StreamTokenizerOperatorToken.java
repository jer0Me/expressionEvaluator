package parser.streamtokenizer;

import java.io.StreamTokenizer;
import parser.Token;

public class StreamTokenizerOperatorToken implements StreamTokenizerTypeToken {

    @Override
    public Token getToken(StreamTokenizer tokenizer) {
        if ((char) tokenizer.ttype == '-') {
            return (Token.symbol(String.valueOf((char) tokenizer.ttype), 2, true));
        }
        if ((char) tokenizer.ttype == '+') {
            return (Token.symbol(String.valueOf((char) tokenizer.ttype), 2, true));
        }
        if ((char) tokenizer.ttype == '/') {
            return (Token.symbol(String.valueOf((char) tokenizer.ttype), 3, true));
        }
        if ((char) tokenizer.ttype == '*') {
            return (Token.symbol(String.valueOf((char) tokenizer.ttype), 3, true));
        }
        if ((char) tokenizer.ttype == '(') {
            return (Token.symbol(String.valueOf((char) tokenizer.ttype), -1, true));
        }
        if ((char) tokenizer.ttype == ')') {
            return (Token.symbol(String.valueOf((char) tokenizer.ttype), -1, true));
        }
        if ((char) tokenizer.ttype == '^') {
            return (Token.symbol(String.valueOf((char) tokenizer.ttype), 4, false));
        }
        return null;

    }
    
    

}
