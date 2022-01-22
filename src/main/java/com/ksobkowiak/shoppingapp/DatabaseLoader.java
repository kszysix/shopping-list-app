package com.ksobkowiak.shoppingapp;

import com.ksobkowiak.shoppingapp.model.Item;
import com.ksobkowiak.shoppingapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ItemRepository repository;

    @Autowired
    public DatabaseLoader(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {

    }

}