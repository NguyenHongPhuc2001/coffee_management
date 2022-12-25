package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Role;
import com.axonactive.coffeemanagement.service.dto.RoleDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface RoleMapper {
    RoleDto toDto(Role role);
    List<RoleDto> toDtos(List<Role> roleList);
}
