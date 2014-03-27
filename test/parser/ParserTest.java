package parser;

import evaluator.Constant;
import java.io.IOException;
import java.util.List;
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
        
        List<Token> listToken = analyzer.analyze("3+2");
        
        assertTrue(listToken.get(0).equals(Token.constant(3.0)));
        assertTrue(listToken.get(1).equals(Token.symbol("+", 2, true)));
        assertTrue(listToken.get(2).equals(Token.constant(2.0)));
    }
    
    @Test
    public void lexicalAnalyzerTest2() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        
        List<Token> listToken = analyzer.analyze("10.0-2");
        
        assertTrue(listToken.get(0).equals(Token.constant(10.0)));
        assertTrue(listToken.get(1).equals(Token.symbol("-", 2, true)));
        assertTrue(listToken.get(2).equals(Token.constant(2.0)));
    }
    
    @Test
    public void lexicalAnalyzerTest3() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        
        List<Token> listToken = analyzer.analyze("10.0/2");
        
        assertTrue(listToken.get(0).equals(Token.constant(10.0)));
        assertTrue(listToken.get(1).equals(Token.symbol("/", 2, true)));
        assertTrue(listToken.get(2).equals(Token.constant(2.0)));
    }
    
    
    @Test
    public void simpleExpressionTest() {
    }
    
}
