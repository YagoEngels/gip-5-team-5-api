package com.example.gip5team5api.inventory;


import com.example.gip5team5api.item.Item;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Item")
    private List<Item> itemList;

    public Inventory() {
    }

    public Inventory(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Long getId() {
        return id;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item item){
        List<Item> items = getItemList();
        items.add(item);
        setItemList(items);
    }

    public void delItem(Item item){
        List<Item> items = getItemList();
        items.remove(item);
        setItemList(items);
    }
}