package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Member;
import com.axonactive.coffeemanagement.service.dto.MemberDto;
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
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDto toDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDto memberDto = new MemberDto();

        memberDto.setPhone( member.getPhone() );
        memberDto.setName( member.getName() );
        memberDto.setBonus( member.getBonus() );

        return memberDto;
    }

    @Override
    public List<MemberDto> toDtos(List<Member> memberList) {
        if ( memberList == null ) {
            return null;
        }

        List<MemberDto> list = new ArrayList<MemberDto>( memberList.size() );
        for ( Member member : memberList ) {
            list.add( toDto( member ) );
        }

        return list;
    }
}
