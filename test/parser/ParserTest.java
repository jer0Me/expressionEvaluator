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
    public void additionExpressionParserTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Parser parser = new ShuntingYardParsing(new SimpleParserStrategy());
        assertEquals(5.0, parser.parse(analyzer.analyze("3+2")).evaluate());
        assertEquals(26.0, parser.parse(analyzer.analyze("3+2+5+7+9")).evaluate());
    }

    @Test
    public void substractionExpressionParserTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Parser parser = new ShuntingYardParsing(new SimpleParserStrategy());
        assertEquals(-49.0, parser.parse(analyzer.analyze("3-52")).evaluate());
        assertEquals(23.0, parser.parse(analyzer.analyze("40-2-5-10")).evaluate());
    }
    
    @Test
    public void multiplicationExpressionParserTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Parser parser = new ShuntingYardParsing(new SimpleParserStrategy());
        assertEquals(9.0, parser.parse(analyzer.analyze("3*3")).evaluate());
        assertEquals(105.0, parser.parse(analyzer.analyze("3*1*5*7")).evaluate());
    }
    
    @Test
    public void divisionExpressionParserTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Parser parser = new ShuntingYardParsing(new SimpleParserStrategy());
        assertEquals(5.0, parser.parse(analyzer.analyze("20/4")).evaluate());
        assertEquals(2.5, parser.parse(analyzer.analyze("20/4/5")).evaluate());
        
    } 
    
    @Test
    public void powExpressionParserTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Parser parser = new ShuntingYardParsing(new SimpleParserStrategy());
        assertEquals(9, parser.parse(analyzer.analyze("3^2")).evaluate());
        assertEquals(81, parser.parse(analyzer.analyze("3^3^2")).evaluate());
    }
    
    @Test
    public void complexExpressionParserTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Parser parser = new ShuntingYardParsing(new SimpleParserStrategy());
        assertEquals(-8.0, parser.parse(analyzer.analyze("3+2-7*3/2")).evaluate());
    }

    @Test
    public void breakCaseExpressionParserTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Parser parser = new ShuntingYardParsing(new SimpleParserStrategy());
        assertEquals(15.0, parser.parse(analyzer.analyze("3+2+(5*4-7)-3")).evaluate());
    }
}
