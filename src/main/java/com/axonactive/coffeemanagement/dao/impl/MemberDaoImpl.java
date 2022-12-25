package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.MemberRequest;
import com.axonactive.coffeemanagement.dao.MemberDao;
import com.axonactive.coffeemanagement.entity.Member;

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
        return em.createQuery("SELECT m FROM Member m")
                .getResultList();
    }

    @Override
    public Member findById(Long memberId) {
        return em.createQuery("SELECT m FROM Member m WHERE m.id = :memberId", Member.class)
                .setParameter("memberId", memberId)
                .getSingleResult();
    }

    @Override
    public Member create(MemberRequest memberRequest) {
        Member member = new Member();
        if (memberRequest.getName() == null || memberRequest.getPhone() == null) {
            return null;
        }
        member.setPhone(memberRequest.getPhone());
        member.setName(memberRequest.getName());
        member.setBonus(0);
        return em.merge(member);
    }

    @Override
    public Member update(MemberRequest memberRequest, Long memberId) {
        Member member = findById(memberId);
        if (member == null) {
            return null;
        }
        if (memberRequest.getBonus() != null) {
            member.setBonus(memberRequest.getBonus());
        }
        if (memberRequest.getPhone() != null) {
            member.setPhone(memberRequest.getPhone());
        }
        if (memberRequest.getName() != null) {
            member.setName(memberRequest.getName());
        }
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
}
