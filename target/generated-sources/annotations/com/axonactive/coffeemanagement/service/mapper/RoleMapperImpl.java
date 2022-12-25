package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Role;
import com.axonactive.coffeemanagement.service.dto.RoleDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-26T00:07:46+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@ApplicationScoped
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDto toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setName( role.getName() );
        roleDto.setDescription( role.getDescription() );

        return roleDto;
    }

    @Override
    public List<RoleDto> toDtos(List<Role> roleList) {
        if ( roleList == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( roleList.size() );
        for ( Role role : roleList ) {
            list.add( toDto( role ) );
        }

        return list;
    }
}
