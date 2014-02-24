package evaluator;

import evaluator.operators.BinaryOperator;
import evaluator.operators.DoubleDoubleAddition;
import evaluator.operators.DoubleDoubleMultiplication;
import evaluator.operators.DoubleIntegerAddition;
import evaluator.operators.DoubleIntegerMultiplication;
import evaluator.operators.IntegerDoubleAddition;
import evaluator.operators.IntegerDoubleMultiplication;
import evaluator.operators.IntegerIntegerAddition;
import evaluator.operators.IntegerIntegerMultiplication;
import java.util.HashMap;
import java.util.Map;

public class BinaryOperatorDictionary {
    private Map<String, BinaryOperator> operators;

    public BinaryOperatorDictionary() {
        operators = new HashMap<>();
        
        operators.put("IntegerIntegerAddition", new IntegerIntegerAddition());
        operators.put("IntegerIntegerMultiplication", new IntegerIntegerMultiplication());
        operators.put("DoubleIntegerAddition", new DoubleIntegerAddition());
        operators.put("DoubleIntegerMultiplication", new DoubleIntegerMultiplication());
        operators.put("IntegerDoubleAddition", new IntegerDoubleAddition());
        operators.put("IntegerDoubleMultiplication", new IntegerDoubleMultiplication());
        operators.put("DoubleDoubleAddition", new DoubleDoubleAddition());
        operators.put("DoubleDoubleMultiplication", new DoubleDoubleMultiplication());
    }

    public BinaryOperator getOperator(String operator, Object left, Object right) {
        return operators.get(getSignature(operator, left, right));
    }

    private String getSignature(String operator, Object left, Object right) {
        return left.getClass().getSimpleName() + right.getClass().getSimpleName() + operator;
    }


}
