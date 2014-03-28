package parser;

import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class ParserTest extends LexicalAnalyzerTest {

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
        assertEquals(1.0, parser.parse(analyzer.analyze("20/4/5")).evaluate());

    }

    @Test
    public void powExpressionParserTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Parser parser = new ShuntingYardParsing(new SimpleParserStrategy());
        assertEquals(9.0, parser.parse(analyzer.analyze("3^2")).evaluate());
        assertEquals(81.0, parser.parse(analyzer.analyze("3^2^2")).evaluate());
    }

    @Test
    public void complexExpressionParserTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Parser parser = new ShuntingYardParsing(new SimpleParserStrategy());
        assertEquals(-5.5, parser.parse(analyzer.analyze("3+2-7*3/2")).evaluate());
    }

    @Test
    public void breakCaseExpressionParserTest() throws IOException {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Parser parser = new ShuntingYardParsing(new SimpleParserStrategy());
        assertEquals(15.0, parser.parse(analyzer.analyze("3+2+(5*4-7)-3")).evaluate());
    }
}
