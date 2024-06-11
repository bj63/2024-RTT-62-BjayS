package org.example.database.dao.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @ToString.Exclude
    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;


    @Column(name = "customer_id", insertable = false, updatable = false)
    private int customerId;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "required_date")
    @Temporal(TemporalType.DATE)
    private Date requiredDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments",columnDefinition = "Text")
    private String comment;

}

