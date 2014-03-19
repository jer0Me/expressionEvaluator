package parser;

import evaluator.BuilderExpression;
import evaluator.Expression;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.reflections.Configuration;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

public class ExpressionFactory {

    public Expression createExpression(SymbolToken symbol, Expression left, Expression right) {
        BuilderExpression builder = getBuilderExpression(symbol);
        return builder.getExpression(left, right);
    }

    private BuilderExpression getBuilderExpression(SymbolToken symbol) {
        Reflections reflections = new Reflections(getConfiguration());
        Set<Class<? extends BuilderExpression>> buildersList = getBuildersList(reflections);
        return getBuilder(buildersList, symbol);
    }

    private Set<Class<? extends BuilderExpression>> getBuildersList(Reflections reflections) {
        Set<Class<? extends BuilderExpression>> builderList = reflections.getSubTypesOf(BuilderExpression.class);
        return builderList;
    }

    private Configuration getConfiguration() {
        return new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false), new ResourcesScanner())
                .setUrls(ClasspathHelper.forPackage("evaluator.builders"))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("evaluator.builders")));
    }

    private BuilderExpression getBuilder(Set<Class<? extends BuilderExpression>> buildersList, SymbolToken symbol) {
        BuilderExpression builder;
        for (Class<? extends BuilderExpression> builderClass : buildersList) {
            try {
                builder = builderClass.newInstance();
                if (builder.getSymbol().equals(symbol)) return builder;
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(ExpressionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
    