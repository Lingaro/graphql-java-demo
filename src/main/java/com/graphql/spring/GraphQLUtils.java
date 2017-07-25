package com.graphql.spring;

import java.util.Optional;
import java.util.regex.Pattern;

public class GraphQLUtils {
    public static boolean isMutation(String query, String operationName) {
        String optionalName = Optional.ofNullable(operationName)
                .map(Pattern::quote)
                .map(pattern -> " +" + pattern)
                .orElse("");
        return Pattern.compile("mutation" + optionalName, Pattern.CASE_INSENSITIVE)
                .matcher(query)
                .find();
    }
}
