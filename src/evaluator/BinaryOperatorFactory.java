package evaluator;

import evaluator.operators.*;

public class BinaryOperatorFactory {

    public BinaryOperatorFactory() {
    }

    public BinaryOperator createOperator(String operator, Object left, Object right) throws InvalidOperationException {
        Class operatorClass;
        try {
            operatorClass = getClass(operator, left, right);
            return (BinaryOperator) operatorClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
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
