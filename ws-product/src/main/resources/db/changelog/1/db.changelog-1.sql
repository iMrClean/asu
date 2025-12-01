--liquibase formatted sql

--changeset stepninkv:1
CREATE TABLE PRODUCT
(
  ID          NUMBER(19),
  NAME        VARCHAR2(255) NOT NULL,
  PRICE       NUMBER(19, 2),
  CONSTRAINT PRODUCT_PK PRIMARY KEY (ID)
);

CREATE SEQUENCE PRODUCT_SEQ START WITH 1 INCREMENT BY 1;

COMMENT ON TABLE PRODUCT IS 'Таблица для хранения информации о товарах';
COMMENT ON COLUMN PRODUCT.ID IS 'Уникальный идентификатор товара';
COMMENT ON COLUMN PRODUCT.NAME IS 'Наименование товара';
COMMENT ON COLUMN PRODUCT.PRICE IS 'Цена товара';
