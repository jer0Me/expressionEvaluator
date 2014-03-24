package parser;

import evaluator.Constant;
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
    public void simpleExpressionTest() {
    }
    
}
