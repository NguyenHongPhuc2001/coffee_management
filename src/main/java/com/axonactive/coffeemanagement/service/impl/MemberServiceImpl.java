package com.axonactive.coffeemanagement.service.impl;

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
    public MemberDto create(MemberDto memberDto) {
        return memberMapper.toDto(memberDao.create(memberDto));
    }

    @Override
    public MemberDto update(MemberDto memberDto, Long memberId) {
        return memberMapper.toDto(memberDao.update(memberDto, memberId));
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
