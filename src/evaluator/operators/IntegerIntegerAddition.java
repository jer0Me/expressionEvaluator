package evaluator.operators;

public class IntegerIntegerAddition extends BinaryOperator {

    @Override
    public Object execute(Object left, Object right) {
        return (Integer) left + (Integer) right;
    }
    
    
}
