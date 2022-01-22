package com.ksobkowiak.shoppingapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }
}
