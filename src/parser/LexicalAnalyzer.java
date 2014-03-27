package parser;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import parser.streamtokenizer.StreamTokenizerNumberToken;
import parser.streamtokenizer.StreamTokenizerOperatorToken;
import parser.streamtokenizer.StreamTokenizerTypeToken;

public class LexicalAnalyzer {

    public List<Token> analyze(String string) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(string));
        tokenizer.ordinaryChar('-');
        tokenizer.ordinaryChar('/');
        return getListToken(tokenizer);
    }
    
    private List<Token> getListToken(StreamTokenizer tokenizer) throws IOException {
        List<Token> tokens = new ArrayList<>();
        while(tokenizer.nextToken() != StreamTokenizer.TT_EOF){
            tokens.add(getToken(tokenizer));
        }
        return tokens;
    }

    private Token getToken(StreamTokenizer tokenizer) {
        return getStreamTokenizerType(tokenizer).getToken(tokenizer);
    }
    
    private StreamTokenizerTypeToken getStreamTokenizerType(StreamTokenizer tokenizer){
        return (tokenizer.ttype == StreamTokenizer.TT_NUMBER? 
                new StreamTokenizerNumberToken(): new StreamTokenizerOperatorToken());
    }
}
