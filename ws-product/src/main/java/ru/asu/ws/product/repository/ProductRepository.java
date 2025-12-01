package ru.asu.ws.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.asu.ws.product.domain.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findAllByOrderByIdAsc();

}
