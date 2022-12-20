package com.axonactive.coffeemanagement.entity;

import com.axonactive.coffeemanagement.utils.Enum.BillStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    private Long id;

    @Column(nullable = false)
    @Null(message = "The total of bill can't be null !")
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
    @JoinColumn(name = "id")
    private BarTable barTable;

    @ManyToOne
    @JoinColumn(name = "id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "id")
    private Promotion promotion;

    @ManyToOne
    @JoinColumn(name = "id")
    private Account account;


    @OneToMany(mappedBy = "bill", fetch = FetchType.EAGER)
    private List<BillDetail> billDetails;
}
