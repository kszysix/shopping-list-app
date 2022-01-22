package com.ksobkowiak.shoppingapp.controller;

import com.ksobkowiak.shoppingapp.dto.ItemDTO;
import com.ksobkowiak.shoppingapp.dto.ShoppingListDTO;
import com.ksobkowiak.shoppingapp.mapper.ItemMapper;
import com.ksobkowiak.shoppingapp.mapper.ShoppingListMapper;
import com.ksobkowiak.shoppingapp.model.Item;
import com.ksobkowiak.shoppingapp.model.ShoppingList;
import com.ksobkowiak.shoppingapp.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/api/v1/list")
public class ShoppingListRestController {

    @Autowired
    private ShoppingListService shoppingListService;

    @Autowired
    private ShoppingListMapper shoppingListMapper;

    @GetMapping("/")
    public ResponseEntity<Iterable<ShoppingListDTO>> index() {
        try {
            return new ResponseEntity<>(
                    shoppingListMapper.map(
                            shoppingListService.listAll()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/items")
    public ResponseEntity<ShoppingList> getListItems(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(
                    shoppingListService.find(id), //.getItems(),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> create(@RequestBody ShoppingListDTO shoppingListDto) {
        try {
            shoppingListService.save(
                    shoppingListMapper.listDTOToList(shoppingListDto)
            );
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingListDTO> update(@PathVariable("id") Integer id, @RequestBody ShoppingListDTO shoppingListDto) {
        try {
            ShoppingList shoppingListEntity = shoppingListService.find(id);
            if (shoppingListEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            shoppingListService.save(
                    shoppingListMapper.listDTOToList(
                            shoppingListDto
                    )
            );
            return new ResponseEntity<>(
                    shoppingListMapper.listToListDTO(
                            shoppingListEntity
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        try {
            ShoppingList shoppingListEntity = shoppingListService.find(id);
            if (shoppingListEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            shoppingListService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}