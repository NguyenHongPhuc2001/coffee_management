package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.controller.request.MemberRequest;
import com.axonactive.coffeemanagement.dao.MemberDao;
import com.axonactive.coffeemanagement.service.MemberService;
import com.axonactive.coffeemanagement.service.dto.MemberDto;
import com.axonactive.coffeemanagement.service.mapper.MemberMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class MemberServiceImpl implements MemberService {

    @Inject
    private MemberDao memberDao;

    @Inject
    private MemberMapper memberMapper;

    @Override
    public List<MemberDto> findAll() {
        return memberMapper.toDtos(memberDao.findAll());
    }

    @Override
    public MemberDto findById(Long memberId) {
        return memberMapper.toDto(memberDao.findById(memberId));
    }

    @Override
    public MemberDto create(MemberRequest memberRequest) {
        return memberMapper.toDto(memberDao.create(memberRequest));
    }

    @Override
    public MemberDto update(MemberRequest memberRequest, Long memberId) {
        return memberMapper.toDto(memberDao.update(memberRequest, memberId));
    }

    @Override
    public void delete(Long memberId) {
        memberDao.delete(memberId);
    }

    @Override
    public MemberDto findByMemberPhone(String memberPhone) {
        return memberMapper.toDto(memberDao.findByMemberPhone(memberPhone));
    }
}
