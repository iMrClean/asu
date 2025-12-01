package ru.asu.ws.order.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "T_ORDER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
  @SequenceGenerator(name = "ORDER_SEQ", sequenceName = "ORDER_SEQ", allocationSize = 1)
  private Long id;

  @Column(name = "ORDER_NUMBER")
  private String orderNumber;

  @Column(name = "SKU_CODE")
  private String skuCode;

  @Column(name = "PRICE")
  private BigDecimal price;

  @Column(name = "QUANTITY")
  private Integer quantity;

}
