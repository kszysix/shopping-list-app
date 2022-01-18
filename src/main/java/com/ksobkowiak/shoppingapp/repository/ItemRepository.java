package com.ksobkowiak.shoppingapp.repository;

import com.ksobkowiak.shoppingapp.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
//    Item findByName(String name);
}