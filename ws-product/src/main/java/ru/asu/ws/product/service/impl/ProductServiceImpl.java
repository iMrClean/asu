package ru.asu.ws.product.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.asu.ws.product.domain.Product;
import ru.asu.ws.product.exception.ProductNotFoundException;
import ru.asu.ws.product.model.ProductRequest;
import ru.asu.ws.product.model.ProductResponse;
import ru.asu.ws.product.repository.ProductRepository;
import ru.asu.ws.product.service.ProductService;
import ru.asu.ws.product.service.map.ProductMapper;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  private final ProductMapper productMapper;

  @Override
  public ProductResponse create(ProductRequest productRequest) {
    Product product = productMapper.toEntity(productRequest);

    Product saved = productRepository.save(product);
    log.info("Product {} is saved", saved.getId());

    return productMapper.toDto(saved);
  }

  @Override
  public ProductResponse update(Long id, ProductRequest productRequest) {
    Product product = productRepository.findById(id)
      .orElseThrow(() -> new ProductNotFoundException(id));

    productMapper.updateEntityFromRequest(productRequest, product);

    Product updatedProduct = productRepository.save(product);
    log.info("Product {} is updated", id);

    return productMapper.toDto(updatedProduct);
  }

  @Override
  public List<ProductResponse> findAll() {
    List<Product> products = productRepository.findAllByOrderByIdAsc();

    return productMapper.toDto(products);
  }

  @Override
  public ProductResponse findById(Long id) {
    Product product = productRepository.findById(id)
      .orElseThrow(() -> new ProductNotFoundException(id));

    return productMapper.toDto(product);
  }

  @Override
  public void delete(Long id) {
    Product product = productRepository.findById(id)
      .orElseThrow(() -> new ProductNotFoundException(id));
    
    productRepository.delete(product);
    log.info("Product {} is deleted", id);
  }

}
