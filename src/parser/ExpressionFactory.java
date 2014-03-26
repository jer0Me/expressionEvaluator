package parser;

import evaluator.BuilderReflections;
import evaluator.BuilderExpression;
import evaluator.Expression;
import java.util.Set;

public class ExpressionFactory {

    public Expression createExpression(SymbolToken symbol, Expression left, Expression right) {
        BuilderExpression builder = getBuilderExpression(symbol);
        return builder.getExpression(left, right);
    }

    private BuilderExpression getBuilderExpression(SymbolToken symbol) {
        BuilderReflections builderReflections = new BuilderReflections<BuilderExpression>() {
            @Override
            public String getNamePackage() {
                return "evaluator.builders";
            }
        };
        Set<Class<? extends BuilderExpression>> buildersList = builderReflections.getBuildersList(BuilderExpression.class);
        return getBuilder(buildersList, symbol);
    }

    private BuilderExpression getBuilder(Set<Class<? extends BuilderExpression>> buildersList, SymbolToken symbol) {
        BuilderExpression builder;
        for (Class<? extends BuilderExpression> builderClass : buildersList) {
            try {
                builder = builderClass.newInstance();
                if (builder.getSymbol().equals(symbol)) return builder;
            } catch (InstantiationException | IllegalAccessException ex) {}
        }
        return null;
    }
}
    