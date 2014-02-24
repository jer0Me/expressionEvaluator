package evaluator;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionTest {
    
//    @Test
    public void testConstant(){
        Assert.assertEquals(3, new Constant(3).evaluate());
        Assert.assertTrue(new Constant(3).evaluate() instanceof Integer);
        Assert.assertTrue(new Constant(3.0).evaluate() instanceof Double);
        Assert.assertEquals(5, new Constant(5).evaluate());
    }

    @Test
    public void testAdd(){
        Assert.assertEquals(3, new Addition(new Constant(1), new Constant(2)).evaluate());
        Assert.assertEquals(14, new Addition(new Constant(2), new Addition (new Constant(4), new Constant(8))).evaluate());
    
    }
    
    @Test
    public void testProduct(){
        Assert.assertEquals(6, new Multiplication(new Constant(2), new Constant(3)).evaluate());
        Assert.assertEquals(8, new Multiplication(new Constant(2), new Constant(4)).evaluate());
        Assert.assertEquals(8.0, new Multiplication(new Constant(2), new Constant(4.0)).evaluate());
        Assert.assertEquals(8.0, new Multiplication(new Constant(2.0), new Constant(4)).evaluate());
        Assert.assertEquals(8.0, new Multiplication(new Constant(2.0), new Constant(4.0)).evaluate());
    }

    
}