package evaluator;

import java.util.Set;
import org.reflections.Configuration;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

public abstract class BuilderReflections<Type> {

    public abstract String getNamePackage();
    
    public Reflections build(){
        return new Reflections(getConfiguration());
    }
    
    private Configuration getConfiguration() {
        return new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false), new ResourcesScanner())
                .setUrls(ClasspathHelper.forPackage(getNamePackage()))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(getNamePackage())));
    }
    
    public Set<Class<? extends Type>> getBuildersList(Reflections reflections, Class<Type> Type) {
        Set<Class<? extends Type>> builderList = reflections.getSubTypesOf(Type);
        return builderList;
    }
    

}
