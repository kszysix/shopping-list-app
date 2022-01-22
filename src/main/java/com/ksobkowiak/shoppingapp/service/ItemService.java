package com.ksobkowiak.shoppingapp.service;

import com.ksobkowiak.shoppingapp.model.Item;
import com.ksobkowiak.shoppingapp.repository.ItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Iterable<Item> listAll(){
        return this.itemRepository.findAll();
    }

    public Item find(long id){
        return this.itemRepository.findById(id).orElse(null);
    }

    public void save(Item item){
        this.itemRepository.save(item);
    }

    public void delete(long id){
        this.itemRepository.deleteById(id);
    }
}
