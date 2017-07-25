package com.graphql.spring.jpa;

import graphql.annotations.GraphQLField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Store {
    private int id;
    private String name;
    private List<Product> products;

    @Id @GeneratedValue
    public int getId() {
        return id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
