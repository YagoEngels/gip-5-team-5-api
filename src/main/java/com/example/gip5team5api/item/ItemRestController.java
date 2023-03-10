package com.example.gip5team5api.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*", allowCredentials = "true")
public class ItemRestController {

    @Autowired
    public ItemService itemService;

    @PutMapping("item/update/{id}")
    public void updateItem(@PathVariable long id, @RequestBody Item item) { itemService.updateItem(id,item); }

    @PutMapping("item/update/{id}/{actie}/{amount}")
    public void addOrRemoveAmount(@PathVariable long id, @PathVariable String actie, @PathVariable int amount){
        itemService.addOrRemoveAmount(id,actie,amount);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("item/add")
    public Item addItem(@RequestBody Item item){
        itemService.addItem(item);
        return item;
    }

    @GetMapping("item/get/{id}")
    public Optional<Item> getItemById(@PathVariable long id) { return itemService.findById(id); }

    @RequestMapping("item/getall")
    public Iterable<Item> getItems() { return itemService.findAll(); }

    @DeleteMapping("item/delete/{id}")
    public void removeItem(@PathVariable long id) {
        itemService.removeItem(itemService.findById(id).get());
    }
}
