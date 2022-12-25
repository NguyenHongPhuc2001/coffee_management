package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Payment;
import com.axonactive.coffeemanagement.service.dto.PaymentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PaymentMapper {
    PaymentDto toDto(Payment payment);
    List<PaymentDto> toDtos(List<Payment> paymentList);
}
