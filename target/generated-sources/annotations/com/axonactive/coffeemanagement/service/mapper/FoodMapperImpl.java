package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Food;
import com.axonactive.coffeemanagement.service.dto.FoodDto;
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
public class FoodMapperImpl implements FoodMapper {

    @Override
    public FoodDto toDto(Food food) {
        if ( food == null ) {
            return null;
        }

        FoodDto foodDto = new FoodDto();

        foodDto.setName( food.getName() );
        foodDto.setPrice( food.getPrice() );
        foodDto.setImage( food.getImage() );
        foodDto.setDescription( food.getDescription() );

        return foodDto;
    }

    @Override
    public List<FoodDto> toDtos(List<Food> foodList) {
        if ( foodList == null ) {
            return null;
        }

        List<FoodDto> list = new ArrayList<FoodDto>( foodList.size() );
        for ( Food food : foodList ) {
            list.add( toDto( food ) );
        }

        return list;
    }
}
