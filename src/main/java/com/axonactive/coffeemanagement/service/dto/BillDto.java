package com.axonactive.coffeemanagement.service.dto;

import com.axonactive.coffeemanagement.entity.*;
import com.axonactive.coffeemanagement.utils.Enum.BillStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {

    private Double total;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    private BillStatusEnum status;

    private BarTable barTableDto;

    private Member member;

    private Payment payment;

    private Promotion promotion;

    private Account account;

    private List<BillDetail> billDetails;
}
