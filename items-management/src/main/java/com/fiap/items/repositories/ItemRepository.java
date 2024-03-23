package com.fiap.items.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fiap.items.models.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String>{
    
}
