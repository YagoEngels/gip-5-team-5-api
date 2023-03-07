package com.example.gip5team5api.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {return itemRepository.findAll(); }

    public Item updateItem(long id, Item _item){
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()){
            item.get().setName(_item.getName());
            item.get().setExtraInfo(_item.getExtraInfo());
            item.get().setModelNr(_item.getModelNr());
            item.get().setPrice(_item.getPrice());
            itemRepository.save(item.get());
            return item.get();
        }
        throw new IllegalArgumentException("Item doesnt exists");
    }

    public void addItem(Item item){
        List<Item> items = itemRepository.findAll();
        for (Item currentItem : items){
            if (currentItem.getId().equals(item.getId())){
                throw new IllegalArgumentException("item bestaat al in de db");
            }
        }
        itemRepository.save(item);
    }

    public Optional<Item> findById(long id) {return itemRepository.findById(id);}

    public void removeItem(Item item) {itemRepository.delete(item);}
}
