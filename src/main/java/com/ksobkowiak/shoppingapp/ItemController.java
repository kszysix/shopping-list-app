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
@RequestMapping("${url.prefix.api.v1}/item")
public class ItemController {

    private final ItemRepository itemRepository;
    private final ShoppingListRepository shoppingListRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository, ShoppingListRepository shoppingListRepository) {
        this.itemRepository = itemRepository;
        this.shoppingListRepository = shoppingListRepository;
    }

    @GetMapping("/")
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        this.itemRepository.findAll().forEach(items::add);
        return items;
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable("id") Integer itemId) {
        return this.itemRepository.findById(Long.valueOf(itemId)).orElse(null);
    }

    @PostMapping("/")
    public String createItem(@RequestParam(value = "content") String content, @RequestParam(value = "listId") long listId) {
        Optional<ShoppingList> shoppingList = this.shoppingListRepository.findById(listId);
        var item = new Item(content, shoppingList.orElse(null));
        this.itemRepository.save(item);
        return ResponseEntity.status(HttpStatus.OK).toString();
    }

}