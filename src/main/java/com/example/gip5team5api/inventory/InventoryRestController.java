package com.example.gip5team5api.inventory;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class InventoryRestController {

    @Autowired
    public InventoryService inventoryService;

    @PutMapping("inventory/update/{id}")
    public void updateInventory(@PathVariable long id, @RequestBody Inventory inventory) {inventoryService.updateInventory(id,inventory);}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("inventory/add")
    public Inventory addInventory(@RequestBody Inventory inventory){
        inventoryService.addInventory(inventory);
        return inventory;
    }

    @GetMapping("inventory/get/{id}")
    public Optional<Inventory> getInventory(@PathVariable long id) {return inventoryService.findById(id); }

    @RequestMapping("inventory/getall")
    public Iterable<Inventory> getInventories() {return  inventoryService.findAll(); }

    @DeleteMapping("inventory/delete/{id}")
    public void removeInventory(@PathVariable long id) {
        inventoryService.removeInventory(inventoryService.findById(id).get());
    }
}
