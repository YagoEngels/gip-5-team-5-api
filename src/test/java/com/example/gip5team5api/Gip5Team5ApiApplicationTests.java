package com.example.gip5team5api;

import com.example.gip5team5api.User.User;
import com.example.gip5team5api.User.UserService;
import com.example.gip5team5api.item.Item;
import com.example.gip5team5api.item.ItemService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Gip5Team5ApiApplicationTests {
    
    private UserService userservice;
    private ItemService itemService;
    private Item testItem;
    private User testUser;

    @BeforeEach
    public void beforeEach(){
        UserService userService = new UserService();
        ItemService itemService = new ItemService();

        testUser = new User("Sander","Raymakers","s.r@gmail.com","02/02/2001","Admin","somebody");
        testItem = new Item("Moederbord","5","een moederbord voor je pc", "150",50,"cpu");


    }

    @Test
    public void testAddUser(){
        // test voor user toe te voegen
        userservice.addUser(testUser);
    }

    @Test
    public void testAddItem(){
        // test voor item toe te voegen.
        itemService.addItem(testItem);
    }


    @Test
    public void testUpdateUser(){
        // test voor user aan te passen
        userservice.updateUser(testUser.getId(),testUser);
    }

    @Test
    public void testUpdateItem(){
        // test voor item aan te passen.
        itemService.updateItem(testItem.getId(),testItem);
    }
    @Test
    public void testDeleteUser(){
        // test voor user te verwijderen
        User delTestUser = new User("Sander","Raymakers","s.r@gmail.com","02/02/2001","Admin","nobody");
        userservice.removeUser(delTestUser);

    }

    @Test
    public void testDeleteItem(){
        // test voor item te verwijderen.
        Item delTestItem = new Item("Moederbord","5","een moederbord voor je pc", "150",20,"cpu");
        itemService.removeItem(delTestItem);
    }

    @Test
    public void testFindAllUsers(){
        // test om alle users te zoeken/vinden.
        userservice.findAll();
    }

    @Test
    public void testFindAllItems(){
        // test om alle items te zoeken/vinden.
        itemService.findAll();
    }

    @Test
    public void testFindUserById(){
        // test om een user met een id te zoeken/vinden.
        userservice.findById(1);
    }

    @Test
    public void testFindItemById(){
        // test om een item met een id te zoeken/vinden.
        itemService.findById(1);
    }


}
