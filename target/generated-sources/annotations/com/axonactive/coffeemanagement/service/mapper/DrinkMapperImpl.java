package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Drink;
import com.axonactive.coffeemanagement.service.dto.DrinkDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-01T23:28:28+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@ApplicationScoped
public class DrinkMapperImpl implements DrinkMapper {

    @Override
    public DrinkDto toDto(Drink drink) {
        if ( drink == null ) {
            return null;
        }

        DrinkDto drinkDto = new DrinkDto();

        drinkDto.setName( drink.getName() );
        drinkDto.setCurrentPrice( drink.getCurrentPrice() );
        drinkDto.setOldPrice( drink.getOldPrice() );
        drinkDto.setImage( drink.getImage() );
        drinkDto.setDescription( drink.getDescription() );

        return drinkDto;
    }

    @Override
    public List<DrinkDto> toDtos(List<Drink> drinkList) {
        if ( drinkList == null ) {
            return null;
        }

        List<DrinkDto> list = new ArrayList<DrinkDto>( drinkList.size() );
        for ( Drink drink : drinkList ) {
            list.add( toDto( drink ) );
        }

        return list;
    }
}
