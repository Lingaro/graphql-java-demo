package com.graphql.spring.jpa.repositories;

import com.graphql.spring.jpa.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    List<Store> findAll();
}