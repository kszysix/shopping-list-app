package com.ksobkowiak.shoppingapp;

import com.google.gson.Gson;
import com.ksobkowiak.shoppingapp.model.Greeting;
import com.ksobkowiak.shoppingapp.model.Item;
import com.ksobkowiak.shoppingapp.repository.ItemRepository;
import com.ksobkowiak.shoppingapp.service.ItemService;
import com.ksobkowiak.shoppingapp.service.ItemServiceImpl;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private ItemService itemService;

    @Autowired
    public HelloController(ItemService itemService) {
        this.itemService = itemService;
    }
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/item")
    public String items() {
        String json = new Gson().toJson(itemService.getItems());
        return json;
    }

}