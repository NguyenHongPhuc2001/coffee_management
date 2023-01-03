package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.service.dto.MemberDto;
import com.axonactive.coffeemanagement.service.dto.PaymentDto;

import java.util.List;

public interface MemberService {
    List<MemberDto> findAll();
    MemberDto findById(Long memberId);
    MemberDto create(MemberDto memberDto);
    MemberDto update(MemberDto memberDto, Long memberId);
    void delete(Long memberId);
    MemberDto findByMemberPhone(String memberPhone);
}
