package ru.asu.ws.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.asu.ws.product.model.ProductRequest;
import ru.asu.ws.product.model.ProductResponse;
import ru.asu.ws.product.service.ProductService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductResponse create(@RequestBody ProductRequest productRequest) {
    log.info("Creating new product: {}", productRequest.getName());
    return productService.create(productRequest);
  }

  @PutMapping("/{id}")
  public ProductResponse update(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
    log.info("Updating product with id: {}", id);
    return productService.update(id, productRequest);
  }
  
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ProductResponse> findAll() {
    log.debug("Fetching all products");
    return productService.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProductResponse findById(@PathVariable Long id) {
    log.debug("Fetching product by id: {}", id);
    return productService.findById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    log.info("Deleting product with id: {}", id);
    productService.delete(id);
  }
  
}
