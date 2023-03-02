package com.example.gip5team5api;

import com.example.gip5team5api.User.UserService;
import com.example.gip5team5api.inventory.InventoryService;
import com.example.gip5team5api.item.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Gip5Team5ApiApplicationTests {
    
    UserService userservice;
    ItemService itemService;
    InventoryService inventoryService;

    @BeforeEach
    public void beforeEach(){
        UserService userService = new UserService();
        ItemService itemService = new ItemService();
        InventoryService inventoryService = new InventoryService();
    }

    @Test
    public void testAddUser(){
        // test voor user toe te voegen
    }

    @Test
    public void testAddItem(){
        // test voor item toe te voegen.
    }

    @Test
    public void testAddInventory(){
        // test voor inventory toe te voegen.
    }

    @Test
    public void testUpdateUser(){
        // test voor user aan te passen
    }

    @Test
    public void testUpdateItem(){
        // test voor item aan te passen.
    }

    @Test
    public void testUpdateInventory(){
        // test voor inventory aan te passen.
    }
    @Test
    public void testDeleteUser(){
        // test voor user te verwijderen
    }

    @Test
    public void testDeleteItem(){
        // test voor item te verwijderen.
    }

    @Test
    public void testDeleteInventory(){
        // test voor inventory te verwijderen.
    }

    @Test
    public void testFindAllUsers(){
        // test om alle users te zoeken/vinden.
    }

    @Test
    public void testFindAllItems(){
        // test om alle items te zoeken/vinden.
    }

    @Test
    public void testFindAllInventories(){
        // test om alle inventories te zoeken/vinden.
    }

    @Test
    public void testFindUserById(){
        // test om een user met een id te zoeken/vinden.
    }

    @Test
    public void testFindItemById(){
        // test om een item met een id te zoeken/vinden.
    }

    @Test
    public void testFindInventoryById(){
        // test om een inventory met een id te zoeken/vinden.
    }

}
