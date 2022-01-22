package com.ksobkowiak.shoppingapp.service;

import com.ksobkowiak.shoppingapp.model.ShoppingList;
import com.ksobkowiak.shoppingapp.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository){
        this.shoppingListRepository = shoppingListRepository;
    }

    public Iterable<ShoppingList> listAll(){
        return this.shoppingListRepository.findAll();
    }

    public ShoppingList find(long id){
        return this.shoppingListRepository.findById(id).orElse(null);
    }

    public void save(ShoppingList shoppingList){
        this.shoppingListRepository.save(shoppingList);
    }

    public void delete(long id){
        this.shoppingListRepository.deleteById(id);
    }
}
