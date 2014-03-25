package parser.streamtokenizer;

import evaluator.BuilderExpression;
import java.io.StreamTokenizer;
import org.reflections.Reflections;
import evaluator.BuilderReflections;
import java.util.Set;
import parser.Token;

public class StreamTokenizerOperatorTokenFactory {

    public Token getToken(StreamTokenizer tokenizer) {
        BuilderReflections builderReflections = new BuilderReflections<BuilderExpression>() {
            @Override
            public String getNamePackage() {
                return "parser.streamtokenizer.operator.builder";
            }
        };
        Reflections reflections = builderReflections.build();

        Set<Class<? extends StreamTokenizerBuilderOperatorToken>> builders = builderReflections.getBuildersList
        (reflections, StreamTokenizerBuilderOperatorToken.class);
        return getBuilder(builders, tokenizer).build();
    }

    private StreamTokenizerBuilderOperatorToken getBuilder(
            Set<Class<? extends StreamTokenizerBuilderOperatorToken>> buildersList, StreamTokenizer tokenizer) {

        StreamTokenizerBuilderOperatorToken builder;
        for (Class<? extends StreamTokenizerBuilderOperatorToken> builderClass : buildersList) {
            try {
                builder = builderClass.newInstance();
                if (builder.getOperator().equals(String.valueOf((char) tokenizer.ttype))) {
                    return builder;
                }
            } catch (InstantiationException | IllegalAccessException ex) {
            }
        }
        return null;
    }
}
