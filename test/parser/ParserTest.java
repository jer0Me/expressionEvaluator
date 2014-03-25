package parser;

import evaluator.Constant;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class ParserTest {

    @Test
    public void expressionFactoryTest() {
        Constant left = new Constant(5);
        Constant right = new Constant(10);
        SymbolToken token = Token.symbol("+", 2, true);
        
        assertEquals(15, new ExpressionFactory().createExpression(token, left, right).evaluate());
    }
    
    @Test
    public void lexicalAnalyzerTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        
        Token[] listToken = analyzer.analyze("3+2");
        
        assertTrue(listToken[0].equals(Token.constant(3.0)));
        assertTrue(listToken[1].equals(Token.symbol("+", 2, true)));
        assertTrue(listToken[2].equals(Token.constant(2.0)));
    }
    
    @Test
    public void lexicalAnalyzerTest2() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        
        Token[] listToken = analyzer.analyze("10.0-2");
        
        assertTrue(listToken[0].equals(Token.constant(10.0)));
        assertTrue(listToken[1].equals(Token.symbol("-", 2, true)));
        assertTrue(listToken[2].equals(Token.constant(2.0)));
    }
    
    
    @Test
    public void simpleExpressionTest() {
    }
    
}
