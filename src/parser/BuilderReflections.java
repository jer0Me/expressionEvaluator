package parser;

import org.reflections.Configuration;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

public abstract class BuilderReflections {

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

}
