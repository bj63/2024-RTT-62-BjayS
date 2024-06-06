package org.example.database.dao.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "products")
public class Product {
    @Id // this is telling hibernate this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // this telling hibernate that the PK is auto increment
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_code", length = 15)
    private String productCode;

    @Column(name = "product_name", length = 70)
    private String productName;

    @Column(name = "productline_id")
    private Integer productlineId;

    @Column(name = "product_scale", length = 10)
    private String productScale;

    @Column(name = "product_vendor", length = 50)
    private String productVendor;

    @Column(name = "product_description", length = 65535, columnDefinition = "text")
    private String productDescription;

    @Column(name = "quantity_in_stock", columnDefinition = "smallint")
    private Integer quantityInStock;

    @Column(name = "buy_price", columnDefinition = "decimal(10,2)")
    private Float buyPrice;

    @Column(name = "msrp", columnDefinition = "decimal(10,2)")
    private Float msrp;
}
