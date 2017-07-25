package com.graphql.spring.graphql.root;

import com.graphql.spring.jpa.Product;
import com.graphql.spring.jpa.repositories.ProductRepository;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class Query {

    private final ProductRepository productRepository;

    public Query(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GraphQLField
    public String serverTime() {
        return LocalDateTime.now().toString();
    }

    @GraphQLField
    public List<Product> getProducts(@GraphQLName("name")String name) {
        if(name == null) {
            return productRepository.findAll();
        }else{
            return productRepository.findByNameContains(name);
        }
    }
}


