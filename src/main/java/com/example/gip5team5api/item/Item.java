package com.example.gip5team5api.item;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    String Name;
    @NotNull
    String ModelNr;
    @NotNull
    String ExtraInfo;
    @NotNull
    String Price;

    @NotNull
    String Type;
    @NotNull
    int Amount;

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getModelNr() {
        return ModelNr;
    }
    public void setModelNr(String modelNr) {
        ModelNr = modelNr;
    }
    public String getExtraInfo() {
        return ExtraInfo;
    }
    public void setExtraInfo(String extraInfo) {
        ExtraInfo = extraInfo;
    }
    public String getPrice() {
        return Price;
    }
    public void setPrice(String price) {
        Price = price;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getAmount() {
        return Amount;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Item(){}
    public Item(String name,
                String modelNr,
                String extraInfo,
                String price, int amount, String type) {
        this.Name = name;
        this.ModelNr = modelNr;
        this.ExtraInfo = extraInfo;
        this.Price = price;
        this.Amount = amount;
        this.Type = type;
    }
}