package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Member;
import com.axonactive.coffeemanagement.service.dto.MemberDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MemberMapper {
    MemberDto toDto(Member member);
    List<MemberDto> toDtos(List<Member> memberList);
}
