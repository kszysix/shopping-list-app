package com.ksobkowiak.shoppingapp.service;

import com.ksobkowiak.shoppingapp.model.Item;
import com.ksobkowiak.shoppingapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemServiceImpl implements ItemService{

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();

        this.itemRepository.findAll().forEach(items::add);

        return items;
    }
}
