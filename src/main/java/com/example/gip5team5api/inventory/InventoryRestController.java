package com.example.gip5team5api.inventory;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class InventoryRestController {

    @Autowired
    public InventoryService inventoryService;

    @PutMapping("/user/{id}")
    public void updateinventory(@PathVariable long id, @RequestBody Inventory inventory) {inventoryService.updateInventory(id,inventory);}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/inventory")
    public Inventory addInventory(@RequestBody Inventory inventory){
        inventoryService.add(inventory);
        return inventory;
    }

    @GetMapping("inventory/{id}")
    public Optional<Inventory> getInventory(@PathVariable long id) {return inventoryService.findById(id); }

    @RequestMapping("inventory")
    public Iterable<Inventory> getInventories() {return  inventoryService.findAll(); }

    @DeleteMapping("inventory/{id}")
    public void removeInventory(@PathVariable long id) {
        inventoryService.removeInventory(inventoryService.findById(id).get());
    }
}
