package evaluator.operators;


public class DoubleDoubleAddition extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Double) left + (Double) right;
    }
    

}
