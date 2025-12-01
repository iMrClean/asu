package ru.asu.ws.product.service;

import ru.asu.ws.product.model.ProductRequest;
import ru.asu.ws.product.model.ProductResponse;

import java.util.List;

public interface ProductService {

  ProductResponse create(ProductRequest productRequest);

  ProductResponse update(Long id, ProductRequest productRequest);

  List<ProductResponse> findAll();

  ProductResponse findById(Long id);

  void delete(Long id);

}
