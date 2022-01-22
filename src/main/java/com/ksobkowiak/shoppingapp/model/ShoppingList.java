package com.ksobkowiak.shoppingapp.model;

import javax.persistence.*;

@Entity
public class ShoppingList {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private long price;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "shoppingList")
//    private List<Item> items = new ArrayList<>();

    public ShoppingList() {
    }

    public ShoppingList(String name) {
        this.name = name;
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
}