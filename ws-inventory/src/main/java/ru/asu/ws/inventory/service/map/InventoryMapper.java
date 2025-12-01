package ru.asu.ws.inventory.service.map;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.asu.ws.inventory.model.InventoryResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryMapper {

  InventoryResponse toDto(Boolean inStock);

}
