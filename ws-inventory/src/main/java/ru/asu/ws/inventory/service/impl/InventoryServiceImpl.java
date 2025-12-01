package ru.asu.ws.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.asu.ws.inventory.model.InventoryResponse;
import ru.asu.ws.inventory.repository.InventoryRepository;
import ru.asu.ws.inventory.service.InventoryService;
import ru.asu.ws.inventory.service.map.InventoryMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

  private final InventoryRepository inventoryRepository;

  private final InventoryMapper inventoryMapper;

  @Override
  public InventoryResponse isInStock(String skuCode, Integer quantity) {
    log.info("Checking Inventory");
    Boolean inStock = inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    return inventoryMapper.toDto(inStock);
  }

}
