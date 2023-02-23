package com.example.gip5team5api.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item ,Long> {
    List<Item> findALl();
}
