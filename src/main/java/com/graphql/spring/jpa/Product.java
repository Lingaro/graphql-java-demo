package com.graphql.spring.jpa;

import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@GraphQLName("Product")
public class Product {
    private int id;
    private Store store;
    private String name;
    private double price;

    @GraphQLField
    @Id @GeneratedValue
    public int getId() {
        return id;
    }

    @GraphQLField
    @NotNull
    public String getName() {
        return name;
    }

    @GraphQLField
    public double getPrice() {
        return price;
    }

    @GraphQLField
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    public Store getStore() {
        return store;
    }

    // ------- Setters --------
    protected void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}