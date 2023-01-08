package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.entity.Member;
import com.axonactive.coffeemanagement.service.dto.MemberDto;

import java.util.List;

public interface MemberDao {
    List<Member> findAll();
    Member findById(Long memberId);
    Member create(MemberDto memberDto);
    Member update(MemberDto memberDto, Long memberId);
    void delete(Long memberId);
    Member findByMemberPhone(String memberPhone);

    List<Member> findMembersHavePromotions();
}
