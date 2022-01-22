package com.ksobkowiak.shoppingapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingList {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private long price;

    @OneToMany(mappedBy = "shoppingList", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Item> items = new ArrayList<Item>();

    public ShoppingList() {
    }

    public ShoppingList(String name) {
        this.name = name;
    }

    public ShoppingList(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}