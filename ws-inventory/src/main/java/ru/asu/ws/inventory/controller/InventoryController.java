package ru.asu.ws.inventory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.asu.ws.inventory.model.InventoryResponse;
import ru.asu.ws.inventory.service.InventoryService;

@Slf4j
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

  private final InventoryService inventoryService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public InventoryResponse isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
    log.info("Received inventory check request for skuCode: {} quantity: {}", skuCode, quantity);
    return inventoryService.isInStock(skuCode, quantity);
  }

}
