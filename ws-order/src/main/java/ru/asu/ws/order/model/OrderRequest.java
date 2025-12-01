package ru.asu.ws.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
  
  private String skuCode;
  private BigDecimal price;
  private Integer quantity;

}
