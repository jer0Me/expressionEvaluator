package parser;

import evaluator.BuilderExpression;
import evaluator.Expression;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false), new ResourcesScanner())
                .setUrls(ClasspathHelper.forPackage("evaluator.builders"))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("evaluator.builders"))));

        Set<Class<? extends BuilderExpression>> builderList = reflections.getSubTypesOf(BuilderExpression.class);

        BuilderExpression builderExpression = null;

        for (Class builder : builderList) {
            try {
                builderExpression = (BuilderExpression) builder.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(BuilderExpression.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (builderExpression.getType().equals(symbol)) {
                return builderExpression;
            }
        }
        return null;
    }

}
