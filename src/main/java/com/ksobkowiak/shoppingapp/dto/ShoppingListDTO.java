package com.ksobkowiak.shoppingapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ShoppingListDTO {

    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private long price;

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("price")
    public long getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(long price) {
        this.price = price;
    }
}
