package parser;

import evaluator.Expression;
import java.util.Set;
import org.reflections.Reflections;

public class ExpressionFactory {

    public Expression createExpression(Token.Symbol symbol, Expression left, Expression right) throws InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("evaluator.expression.builder");
        Set<Class<? extends BuilderExpression>> classes = reflections.getSubTypesOf(BuilderExpression.class);
        for (Class<? extends BuilderExpression> cls : classes) {
            BuilderExpression builderClass = cls.newInstance();
            if(symbol.equals(builderClass.getSymbol())) return builderClass.buildExpression(left, right);
        }
        return null;
    }    
       
}
