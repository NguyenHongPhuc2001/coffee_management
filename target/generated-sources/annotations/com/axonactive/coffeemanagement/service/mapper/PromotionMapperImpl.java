package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Promotion;
import com.axonactive.coffeemanagement.service.dto.PromotionDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-04T00:00:03+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@ApplicationScoped
public class PromotionMapperImpl implements PromotionMapper {

    @Override
    public PromotionDto toDto(Promotion promotion) {
        if ( promotion == null ) {
            return null;
        }

        PromotionDto promotionDto = new PromotionDto();

        promotionDto.setBonus( promotion.getBonus() );
        promotionDto.setName( promotion.getName() );
        promotionDto.setPromotionValue( promotion.getPromotionValue() );
        promotionDto.setStartDate( promotion.getStartDate() );
        promotionDto.setEndDate( promotion.getEndDate() );

        return promotionDto;
    }

    @Override
    public List<PromotionDto> toDtos(List<Promotion> promotionList) {
        if ( promotionList == null ) {
            return null;
        }

        List<PromotionDto> list = new ArrayList<PromotionDto>( promotionList.size() );
        for ( Promotion promotion : promotionList ) {
            list.add( toDto( promotion ) );
        }

        return list;
    }
}
