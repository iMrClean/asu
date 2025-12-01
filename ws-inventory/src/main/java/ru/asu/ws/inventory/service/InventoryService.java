package ru.asu.ws.inventory.service;

import ru.asu.ws.inventory.model.InventoryResponse;

public interface InventoryService {

  InventoryResponse isInStock(String skuCode, Integer quantity);

}
