package com.ksobkowiak.shoppingapp;

import com.google.gson.Gson;
import com.ksobkowiak.shoppingapp.model.Item;
import com.ksobkowiak.shoppingapp.model.ShoppingList;
import com.ksobkowiak.shoppingapp.repository.ItemRepository;
import com.ksobkowiak.shoppingapp.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ShoppingListController {

    private final ItemRepository itemRepository;
    private final ShoppingListRepository shoppingListRepository;

    @Autowired
    public ShoppingListController(ItemRepository itemRepository, ShoppingListRepository shoppingListRepository) {
        this.itemRepository = itemRepository;
        this.shoppingListRepository = shoppingListRepository;
    }

    @GetMapping("/list")
    public List<ShoppingList> getLists() {
        List<ShoppingList> lists = new ArrayList<>();
        this.shoppingListRepository.findAll().forEach(lists::add);
        return lists;
    }

    @GetMapping("/list/{id}")
    public ShoppingList getList(@PathVariable("id") Integer listId) {
        return this.shoppingListRepository.findById(Long.valueOf(listId)).orElse(null);
    }

    @PostMapping("/list")
    public String createList(@RequestParam(value = "name") String name) {
        this.shoppingListRepository.save(new ShoppingList(name));
        return ResponseEntity.status(HttpStatus.OK).toString();
    }

}