package ru.asu.ws.product.service.map;

import org.mapstruct.*;
import ru.asu.ws.product.domain.Product;
import ru.asu.ws.product.model.ProductRequest;
import ru.asu.ws.product.model.ProductResponse;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

  @Mapping(target = "id", ignore = true)
  Product toEntity(ProductRequest productRequest);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(target = "id", ignore = true)
  void updateEntityFromRequest(ProductRequest productRequest, @MappingTarget Product product);

  ProductResponse toDto(Product product);

  List<ProductResponse> toDto(List<Product> products);

}
