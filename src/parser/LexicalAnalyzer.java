package parser;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer {

    public Token[] analyze(String string) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(string));
        tokenizer.ordinaryChar('-'); 
        List<Token> tokBuf = new ArrayList<>();
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            switch (tokenizer.ttype) {
                case StreamTokenizer.TT_NUMBER:
                    tokBuf.add(Token.constant(tokenizer.nval));
                    break;
                default:
                    if((char)tokenizer.ttype == '-') 
                        tokBuf.add(Token.symbol(String.valueOf((char) tokenizer.ttype),2, true));
                    if((char)tokenizer.ttype == '+') 
                        tokBuf.add(Token.symbol(String.valueOf((char) tokenizer.ttype),2, true));
                    if((char)tokenizer.ttype == '/') 
                        tokBuf.add(Token.symbol(String.valueOf((char) tokenizer.ttype),3, true));
                    if((char)tokenizer.ttype == '*') 
                        tokBuf.add(Token.symbol(String.valueOf((char) tokenizer.ttype),3, true));
                    if((char)tokenizer.ttype == '(') 
                        tokBuf.add(Token.symbol(String.valueOf((char) tokenizer.ttype),-1, true));
                    if((char)tokenizer.ttype == ')') 
                        tokBuf.add(Token.symbol(String.valueOf((char) tokenizer.ttype),-1, true));
                    if((char)tokenizer.ttype == '^') 
                        tokBuf.add(Token.symbol(String.valueOf((char) tokenizer.ttype),4, false));
            }
        }
        Token[] listToken = new Token[tokBuf.size()];
        
        for (int i = 0; i < tokBuf.size(); i++) {
            listToken[i] = tokBuf.get(i);
        }
        return listToken;
    }

}
