package com.ksobkowiak.shoppingapp.repository;

import com.ksobkowiak.shoppingapp.model.Item;
import com.ksobkowiak.shoppingapp.model.ShoppingList;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

}