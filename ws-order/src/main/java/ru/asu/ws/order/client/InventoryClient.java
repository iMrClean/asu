package ru.asu.ws.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "http://localhost:8092")
public interface InventoryClient {

  @RequestMapping(value = "/api/inventory", method = RequestMethod.GET)
  boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

}
