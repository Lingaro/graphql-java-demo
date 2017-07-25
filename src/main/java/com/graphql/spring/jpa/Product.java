package com.graphql.spring.jpa;

import graphql.annotations.GraphQLName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
    private int id;
    private Store store;
    private String name;
    private double price;

    
    @Id @GeneratedValue
    public int getId() {
        return id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

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