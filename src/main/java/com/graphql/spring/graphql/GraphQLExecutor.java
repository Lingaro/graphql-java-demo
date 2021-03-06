package com.graphql.spring.graphql;

import com.graphql.spring.GraphQLUtils;
import com.graphql.spring.graphql.root.Mutations;
import com.graphql.spring.graphql.root.Query;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.annotations.GraphQLAnnotations;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GraphQLExecutor {

    private final GraphQL graphQL;
    private final Query queryRoot;
    private final Mutations mutationsRoot;

    @Autowired
    public GraphQLExecutor(Query query, Mutations mutationsRoot)
            throws IllegalAccessException, NoSuchMethodException, InstantiationException {
        this.queryRoot = query;
        this.mutationsRoot = mutationsRoot;
        this.graphQL = createGraphQLSchema();
    }

    public ExecutionResult execute(String query, String operationName, Map<String, Object> variables) {
        Object root = GraphQLUtils.isMutation(query, operationName)
                ? mutationsRoot
                : queryRoot;
        return graphQL.execute(query, operationName, root, variables);
    }

    private GraphQL createGraphQLSchema() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(GraphQLAnnotations.object(Query.class))
                .mutation(GraphQLAnnotations.object(Mutations.class))
                .build();
        return GraphQL.newGraphQL(schema)
                .build();
    }
}
