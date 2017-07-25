package com.graphql.spring.graphql.root;

import com.graphql.spring.jpa.Product;
import com.graphql.spring.jpa.Store;
import com.graphql.spring.jpa.repositories.ProductRepository;
import com.graphql.spring.jpa.repositories.StoreRepository;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;
import org.springframework.stereotype.Component;

@Component
public class Mutations {
    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    public Mutations(StoreRepository storeRepository, ProductRepository productRepository) {
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    @GraphQLField
    public Product addProduct(@GraphQLName("input") ProductInfo input) {
        Product product = new Product();
        product.setName(input.name);
        product.setPrice(input.price);
        product.setStore(storeRepository.findOne(input.storeId));
        return productRepository.save(product);
    }

    @GraphQLField
    public Store addStore(@GraphQLName("name") String name) {
        Store store = new Store();
        store.setName(name);
        return storeRepository.save(store);
    }
}
