package ru.asu.ws.inventory.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "INVENTORY")
public class Inventory {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVENTORY_SEQ")
  @SequenceGenerator(name = "INVENTORY_SEQ", sequenceName = "INVENTORY_SEQ", allocationSize = 1)
  private Long id;

  @Column(name = "SKU_CODE")
  private String skuCode;

  @Column(name = "QUANTITY")
  private Integer quantity;

}
