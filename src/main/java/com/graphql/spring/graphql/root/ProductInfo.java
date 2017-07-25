package com.graphql.spring.graphql.root;

import graphql.annotations.GraphQLField;

import java.util.HashMap;

public class ProductInfo {
    @GraphQLField
    public final String name;
    @GraphQLField
    public final double price;
    @GraphQLField
    public final int storeId;

    public ProductInfo(HashMap<String,Object> values) {
        name = (String) values.get("name");
        price = (double) values.get("price");
        storeId = (int) values.get("storeId");
    }
}
