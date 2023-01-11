package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.dao.MemberDao;
import com.axonactive.coffeemanagement.entity.Member;
import com.axonactive.coffeemanagement.service.MemberService;
import com.axonactive.coffeemanagement.service.PromotionService;
import com.axonactive.coffeemanagement.service.dto.MemberDto;
import com.axonactive.coffeemanagement.service.dto.PromotionDto;
import com.axonactive.coffeemanagement.service.mapper.MemberMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MemberServiceImpl implements MemberService {

    @Inject
    private MemberDao memberDao;

    @Inject
    private MemberMapper memberMapper;

    @Inject
    private PromotionService promotionService;

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

    @Override
    public List<MemberDto> findMembersHavePromotions() {
        List<Member> listMemberHavePromotions = memberDao.findMembersHavePromotions();
        List<MemberDto> listMemberDtoHavePromotions = new ArrayList<>();
        for (Member member : listMemberHavePromotions) {
            listMemberDtoHavePromotions.add(addPromotionsToMemberDto(member, promotionService.findPromotionsByMember(member.getId())));
        }
        return listMemberDtoHavePromotions;
    }

    private MemberDto addPromotionsToMemberDto(Member member, List<PromotionDto> promotionDtoList) {
        MemberDto memberDto = memberMapper.toDto(member);
        memberDto.setPromotions(promotionDtoList);
        return memberDto;
    }
}
