package parser;

import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LexicalAnalyzerTest {

    @Test
    public void lexicalAnalyzerTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        List<Token> listToken = analyzer.analyze("3+2");
        assertTrue(listToken.get(0).equals(Token.constant(3.0)));
        assertTrue(listToken.get(1).equals(Token.symbol("+", 2, true)));
        assertTrue(listToken.get(2).equals(Token.constant(2.0)));
    }

}
