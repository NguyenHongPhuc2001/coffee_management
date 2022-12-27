package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Payment;
import com.axonactive.coffeemanagement.service.dto.PaymentDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-28T00:37:57+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@ApplicationScoped
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentDto toDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setName( payment.getName() );
        paymentDto.setImage( payment.getImage() );

        return paymentDto;
    }

    @Override
    public List<PaymentDto> toDtos(List<Payment> paymentList) {
        if ( paymentList == null ) {
            return null;
        }

        List<PaymentDto> list = new ArrayList<PaymentDto>( paymentList.size() );
        for ( Payment payment : paymentList ) {
            list.add( toDto( payment ) );
        }

        return list;
    }
}
