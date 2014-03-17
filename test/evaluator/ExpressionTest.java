package evaluator;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExpressionTest {

    @Test
    public void testNumberConstant() {
        assertEquals(3, new Constant(3).evaluate());
        assertEquals(5.0, (Double) new Constant(5.0).evaluate(), 0.001);
        //Assert.assertTrue(new Constant(3).evaluate() instanceof Integer);
        //Assert.assertTrue(new Constant(3.0).evaluate() instanceof Double);
    }

    @Test
    public void testNumberAdd() {
        assertEquals(3, new Addition(new Constant(1), new Constant(2)).evaluate());
        assertEquals(14, new Addition(new Constant(2), new Addition(new Constant(4), new Constant(8))).evaluate());

    }

    @Test
    public void testNumberProduct() {
        assertEquals(6, new Multiplication(new Constant(2), new Constant(3)).evaluate());
        assertEquals(8, new Multiplication(new Constant(2), new Constant(4)).evaluate());
        assertEquals(8.0, new Multiplication(new Constant(2), new Constant(4.0)).evaluate());
        assertEquals(8.0, new Multiplication(new Constant(2.0), new Constant(4)).evaluate());
        assertEquals(8.0, new Multiplication(new Constant(2.0), new Constant(4.0)).evaluate());
    }
    
    @Test
    public void testNumberSubtraction() {
        assertEquals(5, new Subtraction(new Constant(10), new Constant(5)).evaluate());
        assertEquals(10.0, new Subtraction(new Constant(20), new Constant(10.0)).evaluate());
        assertEquals(2.5, new Subtraction(new Constant(5.0), new Constant(2.5)).evaluate());
        assertEquals(5.0, new Subtraction(new Constant(10.0), new Constant(5)).evaluate());        
    }
    
    @Test
    public void testNumberDivision() {
        assertEquals(2, new Division(new Constant(10), new Constant(5)).evaluate());
        assertEquals(5.0, new Division(new Constant(10), new Constant(2.0)).evaluate());
        assertEquals(2.5, new Division(new Constant(5.0), new Constant(2)).evaluate());
        assertEquals(3, new Division(new Constant(10), new Constant(3)).evaluate());
    }
    
    @Test
    public void testMinusNumber() {
        assertEquals(-10, new Minus(new Constant(10)).evaluate());
    }
}
