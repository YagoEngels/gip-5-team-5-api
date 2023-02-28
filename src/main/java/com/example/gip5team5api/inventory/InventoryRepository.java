package com.example.gip5team5api.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    List<Inventory> findAll();
}
