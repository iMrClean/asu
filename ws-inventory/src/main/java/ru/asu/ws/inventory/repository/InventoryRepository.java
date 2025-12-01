package ru.asu.ws.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.asu.ws.inventory.domain.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

  Boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);

}
