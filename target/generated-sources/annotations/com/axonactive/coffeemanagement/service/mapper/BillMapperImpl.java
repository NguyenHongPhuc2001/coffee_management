package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Bill;
import com.axonactive.coffeemanagement.entity.BillDetail;
import com.axonactive.coffeemanagement.service.dto.BillDto;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T01:27:41+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@ApplicationScoped
public class BillMapperImpl implements BillMapper {

    @Override
    public BillDto toDto(Bill bill) {
        if ( bill == null ) {
            return null;
        }

        BillDto billDto = new BillDto();

        billDto.setTotal( bill.getTotal() );
        billDto.setActualReceived( bill.getActualReceived() );
        if ( bill.getCreatedDate() != null ) {
            billDto.setCreatedDate( Date.from( bill.getCreatedDate().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }
        billDto.setStatus( bill.getStatus() );
        billDto.setBarTable( bill.getBarTable() );
        billDto.setMember( bill.getMember() );
        billDto.setPayment( bill.getPayment() );
        billDto.setPromotion( bill.getPromotion() );
        billDto.setAccount( bill.getAccount() );
        List<BillDetail> list = bill.getBillDetails();
        if ( list != null ) {
            billDto.setBillDetails( new ArrayList<BillDetail>( list ) );
        }

        return billDto;
    }

    @Override
    public List<BillDto> toDtos(List<Bill> bills) {
        if ( bills == null ) {
            return null;
        }

        List<BillDto> list = new ArrayList<BillDto>( bills.size() );
        for ( Bill bill : bills ) {
            list.add( toDto( bill ) );
        }

        return list;
    }
}
