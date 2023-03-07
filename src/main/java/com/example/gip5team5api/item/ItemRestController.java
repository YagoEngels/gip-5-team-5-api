package com.example.gip5team5api.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class ItemRestController {

    @Autowired
    public ItemService itemService;

    @PutMapping("item/{id}")
    public void updateItem(@PathVariable long id, @RequestBody Item item) { itemService.updateItem(id,item); }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/item")
    public Item addItem(@RequestBody Item item){
        itemService.addItem(item);
        return item;
    }

    @GetMapping("item/{id}")
    public Optional<Item> getItemById(@PathVariable long id) { return itemService.findById(id); }

    @RequestMapping("/item")
    public Iterable<Item> getItems() { return itemService.findAll(); }

    @DeleteMapping("/item/{id}")
    public void removeItem(@PathVariable long id) {
        itemService.removeItem(itemService.findById(id).get());
    }
}
