package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.dao.MemberDao;
import com.axonactive.coffeemanagement.entity.Member;
import com.axonactive.coffeemanagement.service.dto.MemberDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MemberDaoImpl implements MemberDao {

    @PersistenceContext(name = "coffee_management")

    EntityManager em;

    @Override
    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    @Override
    public Member findById(Long memberId) {
        return em.createQuery("SELECT m FROM Member m WHERE m.id = :memberId", Member.class)
                .setParameter("memberId", memberId)
                .getSingleResult();
    }

    @Override
    public Member create(MemberDto memberDto) {
        Member member = new Member();
        if (memberDto.getName() == null || memberDto.getPhone() == null) {
            return null;
        }
        member.setPhone(memberDto.getPhone().trim());
        member.setName(memberDto.getName().trim());
        member.setBonus(0);
        return em.merge(member);
    }

    @Override
    public Member update(MemberDto memberDto, Long memberId) {
        Member member = findById(memberId);
        member.setBonus(memberDto.getBonus());
        member.setPhone(memberDto.getPhone().trim());
        member.setName(memberDto.getName().trim());
        return em.merge(member);
    }

    @Override
    public void delete(Long memberId) {
        Member member = findById(memberId);
        if (member != null) {
            em.remove(member);
        }
    }

    @Override
    public Member findByMemberPhone(String memberPhone) {
        Member member = em.createQuery("SELECT m FROM Member m WHERE m.phone = :memberPhone", Member.class)
                .setParameter("memberPhone", memberPhone)
                .getSingleResult();
        if (member == null) {
            throw new NoResultException("No member found !");
        } else {
            return member;
        }
    }

    @Override
    public List<Member> findMembersHavePromotions() {
        return em.createQuery("SELECT m FROM Member m INNER JOIN Promotion p ON m.bonus >= p.bonus GROUP BY m ORDER BY m ASC", Member.class)
                .getResultList();
    }
}
