package com.example.gip5team5api.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> findAll() {return inventoryRepository.findAll(); }

    public Inventory updateInventory(long id, Inventory _inventory){
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        if(inventory.isPresent()){
            inventory.get().setItemList(_inventory.getItemList());

            inventoryRepository.save(inventory.get());
            return inventory.get();
        }
        throw new IllegalArgumentException("User already exists");
    }

    public void add(Inventory inventory){
        List<Inventory> inventories = inventoryRepository.findAll();
        for(Inventory currentInventory : inventories){
            if(currentInventory.getId().equals(inventory.getId())){
                throw new IllegalArgumentException("Inventory already exists");
            }
        }
        inventoryRepository.save(inventory);
    }
    public Optional<Inventory> findById(long id) { return inventoryRepository.findById(id); }

    public void removeInventory(Inventory inventory){ inventoryRepository.delete(inventory); }
}
