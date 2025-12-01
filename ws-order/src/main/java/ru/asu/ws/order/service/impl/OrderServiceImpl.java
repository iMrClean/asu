package ru.asu.ws.order.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.asu.ws.order.domain.Order;
import ru.asu.ws.order.exception.OrderNotFoundException;
import ru.asu.ws.order.model.OrderRequest;
import ru.asu.ws.order.model.OrderResponse;
import ru.asu.ws.order.repository.OrderRepository;
import ru.asu.ws.order.service.OrderService;
import ru.asu.ws.order.service.map.OrderMapper;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

//  private final InventoryClient inventoryClient;

  private final OrderMapper orderMapper;

  @Override
  public OrderResponse create(OrderRequest orderRequest) {
//    boolean inStock = inventoryClient.isInStock(orderRequest.getSkuCode(), orderRequest.getQuantity());
//    if (!inStock) {
//      throw new IllegalArgumentException("Product is not in stock, please try again later");
//    }

    Order order = orderMapper.toEntity(orderRequest);

    Order saved = orderRepository.save(order);
    log.info("Order {} is saved", saved.getId());

    return orderMapper.toDto(saved);
  }

  @Override
  public OrderResponse update(Long id, OrderRequest orderRequest) {
    Order order = orderRepository.findById(id)
      .orElseThrow(() -> new OrderNotFoundException(id));

    orderMapper.updateEntityFromRequest(orderRequest, order);

    Order updatedOrder = orderRepository.save(order);
    log.info("Order {} is updated", updatedOrder.getId());

    return orderMapper.toDto(updatedOrder);
  }

  @Override
  public List<OrderResponse> findAll() {
    List<Order> products = orderRepository.findAllByOrderByIdAsc();

    return orderMapper.toDto(products);
  }

  @Override
  public OrderResponse findById(Long id) {
    Order order = orderRepository.findById(id)
      .orElseThrow(() -> new OrderNotFoundException(id));

    return orderMapper.toDto(order);
  }

  @Override
  public void deleteById(Long id) {
    Order order = orderRepository.findById(id)
      .orElseThrow(() -> new OrderNotFoundException(id));

    orderRepository.delete(order);
    log.info("Order {} is deleted", id);
  }

}
