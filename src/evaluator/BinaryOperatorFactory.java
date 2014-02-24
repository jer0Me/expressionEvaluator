package evaluator;

import evaluator.operators.DoubleDoubleAddition;
import evaluator.operators.DoubleIntegerAddition;
import evaluator.operators.BinaryOperator;
import evaluator.operators.DoubleDoubleMultiplication;
import evaluator.operators.DoubleIntegerMultiplication;
import evaluator.operators.IntegerDoubleAddition;
import evaluator.operators.IntegerDoubleMultiplication;
import evaluator.operators.IntegerIntegerAddition;
import evaluator.operators.IntegerIntegerMultiplication;
import java.util.HashMap;
import java.util.Map;

public class BinaryOperatorFactory {
    private Map<String, BinaryOperatorBuilder> builders;

    public BinaryOperatorFactory() {
        builders = new HashMap<>();
        
        builders.put("IntegerIntegerMultiplication", new BinaryOperatorBuilder() {
            @Override
            public BinaryOperator build(Object left, Object right) {
                return new IntegerIntegerMultiplication(left, right);
            }
        });
        builders.put("DoubleIntegerMultiplication", new BinaryOperatorBuilder() {
            @Override
            public BinaryOperator build(Object left, Object right) {
                return new DoubleIntegerMultiplication(left, right);
            }
        });
        builders.put("IntegerDoubleMultiplication", new BinaryOperatorBuilder() {
            @Override
            public BinaryOperator build(Object left, Object right) {
                return new IntegerDoubleMultiplication(left, right);
            }
        });
        builders.put("DoubleDoubleMultiplication", new BinaryOperatorBuilder() {
            @Override
            public BinaryOperator build(Object left, Object right) {
                return new DoubleDoubleMultiplication(left, right);
            }
        });
        builders.put("IntegerIntegerAddition", new BinaryOperatorBuilder() {
            @Override
            public BinaryOperator build(Object left, Object right) {
                return new IntegerIntegerAddition(left, right);
            }
        });
        builders.put("DoubleIntegerAddition", new BinaryOperatorBuilder() {
            @Override
            public BinaryOperator build(Object left, Object right) {
                return new DoubleIntegerAddition(left, right);
            }
        });
        builders.put("IntegerDoubleAddition", new BinaryOperatorBuilder() {
            @Override
            public BinaryOperator build(Object left, Object right) {
                return new IntegerDoubleAddition(left, right);
            }
        });
        builders.put("DoubleDoubleAddition", new BinaryOperatorBuilder() {
            @Override
            public BinaryOperator build(Object left, Object right) {
                return new DoubleDoubleAddition(left, right);
            }
        });
    }

    public BinaryOperator getOperator(String operator, Object left, Object right) {
        return builders.get(getSignature(operator, left, right)).build(left, right);
    }

    private String getSignature(String operator, Object left, Object right) {
        return left.getClass().getSimpleName() + right.getClass().getSimpleName() + operator;
    }

    public interface BinaryOperatorBuilder {

        public BinaryOperator build(Object left, Object right);
    }

}
