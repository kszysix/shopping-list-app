package com.ksobkowiak.shoppingapp.model;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="listId")
    private ShoppingList shoppingList;

    public Item(String content, ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
        this.content = content;
    }

    public Item(String content) {
        this(content, null);
    }

    public Item() {
        this("N/D");
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
