package com.ksobkowiak.shoppingapp.model;

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

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "shoppingList")
    private List<Item> items = new ArrayList<>();

    public ShoppingList() {
    }

    public ShoppingList(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}