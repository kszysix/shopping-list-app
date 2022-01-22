package com.ksobkowiak.shoppingapp.controller;

import com.ksobkowiak.shoppingapp.mapper.ItemMapper;
import com.ksobkowiak.shoppingapp.model.Item;
import com.ksobkowiak.shoppingapp.dto.ItemDTO;
import com.ksobkowiak.shoppingapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = { "http://localhost:8081"})
@RestController
@RequestMapping("/api/v1/item")
public class ItemRestController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemMapper itemMapper;

    @GetMapping("/")
    public ResponseEntity<Iterable<ItemDTO>> index() {
        try {
            return new ResponseEntity<>(
                    itemMapper.map(
                            itemService.listAll()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> create(@RequestBody ItemDTO itemDto) {
        try {
            itemService.save(
                    itemMapper.itemDTOToItem(itemDto)
            );
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> update(@PathVariable("id") Integer id, @RequestBody ItemDTO itemDto) {
        try {
            Item itemEntity = itemService.find(id);
            if (itemEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            itemService.save(
                    itemMapper.itemDTOToItem(
                            itemDto
                    )
            );
            return new ResponseEntity<>(
                    itemMapper.itemToItemDTO(
                            itemEntity
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
            Item itemEntity = itemService.find(id);
            if (itemEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } //if
            itemService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}