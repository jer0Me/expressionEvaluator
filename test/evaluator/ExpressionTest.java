package evaluator;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionTest {

    @Test
    public void testNumberConstant() {
        Assert.assertEquals(3, new Constant(3).evaluate());
        Assert.assertEquals(5.0, (Double) new Constant(5.0).evaluate(), 0.001);
        //Assert.assertTrue(new Constant(3).evaluate() instanceof Integer);
        //Assert.assertTrue(new Constant(3.0).evaluate() instanceof Double);
    }

    @Test
    public void testNumberAdd() {
        Assert.assertEquals(3, new Addition(new Constant(1), new Constant(2)).evaluate());
        Assert.assertEquals(14, new Addition(new Constant(2), new Addition(new Constant(4), new Constant(8))).evaluate());

    }

    @Test
    public void testNumberProduct() {
        Assert.assertEquals(6, new Multiplication(new Constant(2), new Constant(3)).evaluate());
        Assert.assertEquals(8, new Multiplication(new Constant(2), new Constant(4)).evaluate());
        Assert.assertEquals(8.0, new Multiplication(new Constant(2), new Constant(4.0)).evaluate());
        Assert.assertEquals(8.0, new Multiplication(new Constant(2.0), new Constant(4)).evaluate());
        Assert.assertEquals(8.0, new Multiplication(new Constant(2.0), new Constant(4.0)).evaluate());
    }

}
