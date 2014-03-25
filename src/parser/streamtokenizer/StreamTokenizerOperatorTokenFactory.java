package parser.streamtokenizer;

import java.io.StreamTokenizer;
import org.reflections.Reflections;
import evaluator.BuilderReflections;
import java.util.Set;
import parser.Token;

public class StreamTokenizerOperatorTokenFactory {

    public Token getToken(StreamTokenizer tokenizer) {
        Reflections reflections = new BuilderReflections() {
            @Override
            public String getNamePackage() {
                return "parser.streamtokenizer.operator.builder";
            }
        }.build();

        Set<Class<? extends StreamTokenizerBuilderOperatorToken>> builders = getBuilderList(reflections);
        return getBuilder(builders, tokenizer).build();
    }

    private Set<Class<? extends StreamTokenizerBuilderOperatorToken>> getBuilderList(Reflections reflections) {
        Set<Class<? extends StreamTokenizerBuilderOperatorToken>> builderList
                = reflections.getSubTypesOf(StreamTokenizerBuilderOperatorToken.class);
        return builderList;
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

    private String getClasss() {
        return null;
    }
}
