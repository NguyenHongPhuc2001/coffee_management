package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.BarTable;
import com.axonactive.coffeemanagement.service.dto.BarTableDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T01:27:41+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@ApplicationScoped
public class BarTableMapperImpl implements BarTableMapper {

    @Override
    public BarTableDto toDto(BarTable barTable) {
        if ( barTable == null ) {
            return null;
        }

        BarTableDto barTableDto = new BarTableDto();

        barTableDto.setNumber( barTable.getNumber() );
        barTableDto.setNumberOfSeat( barTable.getNumberOfSeat() );
        barTableDto.setStatus( barTable.getStatus() );

        return barTableDto;
    }

    @Override
    public List<BarTableDto> toDtos(List<BarTable> barTableList) {
        if ( barTableList == null ) {
            return null;
        }

        List<BarTableDto> list = new ArrayList<BarTableDto>( barTableList.size() );
        for ( BarTable barTable : barTableList ) {
            list.add( toDto( barTable ) );
        }

        return list;
    }
}
