package evaluator;

import evaluator.InvalidOperationException;
import evaluator.operators.*;

public class UnaryOperatorFactory {

    public UnaryOperatorFactory() {
    }

    public UnaryOperator createOperator(String operator, Object expression) throws InvalidOperationException {
        Class operatorClass;
        try {
            operatorClass = getClass(operator, expression);
            return (UnaryOperator) operatorClass.newInstance();
        } catch (Exception ex) {
            throw new InvalidOperationException();
        }
    }

    private String getSignature(String operator, Object expression) {
        return expression.getClass().getSimpleName() + operator;
    }

    private Class getClass(String operator, Object expression) throws ClassNotFoundException {
        return Class.forName(getPackage(operator) + getSignature(operator, expression));
        
    }

    private String getPackage(String operator) {
        return "evaluator.operators." + operator.toLowerCase() + ".";
    }


}
