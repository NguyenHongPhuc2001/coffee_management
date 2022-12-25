package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.controller.request.MemberRequest;
import com.axonactive.coffeemanagement.service.dto.MemberDto;

import java.util.List;

public interface MemberService {
    List<MemberDto> findAll();
    MemberDto findById(Long memberId);
    MemberDto create(MemberRequest memberRequest);
    MemberDto update(MemberRequest memberRequest, Long memberId);
    void delete(Long memberId);
    MemberDto findByMemberPhone(String memberPhone);
}
