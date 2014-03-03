package evaluator;

import evaluator.operators.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperatorFactory {

    public OperatorFactory() {
    }

    public BinaryOperator createOperator(String operator, Object left, Object right) throws InvalidOperationException {
        Class operatorClass;
        try {
            operatorClass = getClass(operator, left, right);
            return (BinaryOperator) operatorClass.newInstance();
        } catch (Exception ex) {
            throw new InvalidOperationException();
        }
    }

    private String getSignature(String operator, Object left, Object right) {
        return left.getClass().getSimpleName() + right.getClass().getSimpleName() + operator;
    }

    private Class getClass(String operator, Object left, Object right) throws ClassNotFoundException {
        return Class.forName(getPackage(operator) + getSignature(operator, left, right));
        
    }

    private String getPackage(String operator) {
        return "evaluator.operators." + operator.toLowerCase() + ".";
    }


}
