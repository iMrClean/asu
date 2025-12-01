package ru.asu.ws.order.service;

import ru.asu.ws.order.model.OrderRequest;
import ru.asu.ws.order.model.OrderResponse;

import java.util.List;

public interface OrderService {

  OrderResponse create(OrderRequest orderRequest);

  OrderResponse update(Long id, OrderRequest orderRequest);

  List<OrderResponse> findAll();

  OrderResponse findById(Long id);

  void deleteById(Long id);

}
