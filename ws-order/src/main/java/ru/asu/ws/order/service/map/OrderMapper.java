package ru.asu.ws.order.service.map;

import org.mapstruct.*;
import ru.asu.ws.order.domain.Order;
import ru.asu.ws.order.model.OrderRequest;
import ru.asu.ws.order.model.OrderResponse;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "orderNumber", expression = "java(String.valueOf(java.util.UUID.randomUUID()))")
  @Mapping(target = "price", expression = "java(orderRequest.getPrice().multiply(java.math.BigDecimal.valueOf(orderRequest.getQuantity())))")
  Order toEntity(OrderRequest orderRequest);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "orderNumber", ignore = true)
  void updateEntityFromRequest(OrderRequest orderRequest, @MappingTarget Order order);

  OrderResponse toDto(Order order);

  List<OrderResponse> toDto(List<Order> orders);

}
