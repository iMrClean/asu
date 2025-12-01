package ru.asu.ws.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.asu.ws.order.model.OrderRequest;
import ru.asu.ws.order.model.OrderResponse;
import ru.asu.ws.order.service.OrderService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OrderResponse create(@RequestBody OrderRequest orderRequest) {
    log.info("Creating new order: {}", orderRequest.getSkuCode());
    return orderService.create(orderRequest);
  }

  @PutMapping("/{id}")
  public OrderResponse update(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
    log.info("Updating order with id: {}", id);
    return orderService.update(id, orderRequest);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<OrderResponse> findAll() {
    log.debug("Fetching all orders");
    return orderService.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public OrderResponse findById(@PathVariable Long id) {
    log.debug("Fetching order by id: {}", id);
    return orderService.findById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    log.info("Deleting order with id: {}", id);
    orderService.deleteById(id);
  }
  
}
