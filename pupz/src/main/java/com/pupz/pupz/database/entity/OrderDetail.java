package com.pupz.pupz.database.entity;
import com.pupz.pupz.database.entity.Dog;
import jakarta.persistence.*;
import lombok.*;

import java.awt.print.Book;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id", insertable=false, updatable=false)
    private Integer orderID;

    @Column(name = "dog_id", insertable=false, updatable=false)
    private Integer dogID;

    @Column(name = "quantity_ordered")
    private Integer quantityOrdered;

    @Column(name = "price_each", columnDefinition = "DECIMAL")
    private Double priceEach;

    @Column(name = "order_line_number", columnDefinition = "SMALLINT")
    private Integer orderLineNumber;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dog_id", nullable = false)
    private Dog dog;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
