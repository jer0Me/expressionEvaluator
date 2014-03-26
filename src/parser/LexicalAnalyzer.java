package parser;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import parser.streamtokenizer.StreamTokenizerNumberToken;
import parser.streamtokenizer.StreamTokenizerOperatorToken;
import parser.streamtokenizer.StreamTokenizerTypeToken;

public class LexicalAnalyzer {

    public Token[] analyze(String string) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(string));
        tokenizer.ordinaryChar('-');
        return getListToken(tokenizer);
    }

    private Token[] getListToken(StreamTokenizer tokenizer) throws IOException {
        ArrayList<Token> tokens = new ArrayList<>();
        while(tokenizer.nextToken() != StreamTokenizer.TT_EOF){
            tokens.add(getToken(tokenizer));
        }
        return getArrayTokens(tokens);
    }

    private Token getToken(StreamTokenizer tokenizer) {
        return getStreamTokenizerType(tokenizer).getToken(tokenizer);
    }
    
    private StreamTokenizerTypeToken getStreamTokenizerType(StreamTokenizer tokenizer){
        return (tokenizer.ttype == StreamTokenizer.TT_NUMBER? 
                new StreamTokenizerNumberToken(): new StreamTokenizerOperatorToken());
    }

    private Token[] getArrayTokens(ArrayList<Token> tokens) {
        Token[] listToken = new Token[tokens.size()];
        for (int i = 0; i < tokens.size(); i++) {
            listToken[i] = tokens.get(i);
        }
        return listToken;
    }
    
}
