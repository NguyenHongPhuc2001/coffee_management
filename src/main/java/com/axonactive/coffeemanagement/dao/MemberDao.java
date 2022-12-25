package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.controller.request.MemberRequest;
import com.axonactive.coffeemanagement.entity.Member;

import java.util.List;

public interface MemberDao {
    List<Member> findAll();
    Member findById(Long memberId);
    Member create(MemberRequest memberRequest);
    Member update(MemberRequest memberRequest, Long memberId);
    void delete(Long memberId);
    Member findByMemberPhone(String memberPhone);
}
