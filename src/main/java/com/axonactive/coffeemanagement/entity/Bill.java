package com.axonactive.coffeemanagement.entity;

import com.axonactive.coffeemanagement.utils.Enum.BillStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "The total of bill can't be null !")
    private Double total;

    @Column(name = "created_date")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private Date updatedDate;

    @Enumerated(EnumType.STRING)
    private BillStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "bar_table_id")
    private BarTable barTable;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "bill", fetch = FetchType.EAGER)
    private List<BillDetail> billDetails;
}
