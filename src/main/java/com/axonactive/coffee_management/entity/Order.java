package com.axonactive.coffee_management.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;


    @Column(name = "created_date")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "total_order")
    private BigDecimal totalOrder;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "order_status")
    private Integer orderStatus;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;


    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private com.axonactive.coffee_management.entity.Table table;


    @OneToMany(mappedBy = "order")
    private List<Orderdetail> orderdetails;

}
