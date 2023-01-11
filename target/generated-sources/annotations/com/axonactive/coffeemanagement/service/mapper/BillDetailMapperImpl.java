package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.BillDetail;
import com.axonactive.coffeemanagement.service.dto.BillDetailDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T01:27:42+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@ApplicationScoped
public class BillDetailMapperImpl implements BillDetailMapper {

    @Override
    public BillDetailDto toDto(BillDetail billDetail) {
        if ( billDetail == null ) {
            return null;
        }

        BillDetailDto billDetailDto = new BillDetailDto();

        billDetailDto.setQuantity( billDetail.getQuantity() );
        billDetailDto.setTotal( billDetail.getTotal() );
        billDetailDto.setBill( billDetail.getBill() );
        billDetailDto.setFood( billDetail.getFood() );
        billDetailDto.setDrink( billDetail.getDrink() );

        return billDetailDto;
    }

    @Override
    public List<BillDetailDto> toDtos(List<BillDetail> billDetails) {
        if ( billDetails == null ) {
            return null;
        }

        List<BillDetailDto> list = new ArrayList<BillDetailDto>( billDetails.size() );
        for ( BillDetail billDetail : billDetails ) {
            list.add( toDto( billDetail ) );
        }

        return list;
    }
}
