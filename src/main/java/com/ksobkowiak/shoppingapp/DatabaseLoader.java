package com.ksobkowiak.shoppingapp;

import com.ksobkowiak.shoppingapp.model.Item;
import com.ksobkowiak.shoppingapp.model.ShoppingList;
import com.ksobkowiak.shoppingapp.repository.ItemRepository;
import com.ksobkowiak.shoppingapp.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ItemRepository itemRepository;
    private final ShoppingListRepository shoppingListRepository;

    @Autowired
    public DatabaseLoader(ItemRepository itemRepository, ShoppingListRepository shoppingListRepository) {
        this.itemRepository = itemRepository;
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

    }

}