package ru.asu.ws.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.asu.ws.order.domain.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

  List<Order> findAllByOrderByIdAsc();

}
