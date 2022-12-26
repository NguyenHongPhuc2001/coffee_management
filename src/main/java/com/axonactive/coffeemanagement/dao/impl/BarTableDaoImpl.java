package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.BarTableRequest;
import com.axonactive.coffeemanagement.dao.BarTableDao;
import com.axonactive.coffeemanagement.entity.BarTable;
import com.axonactive.coffeemanagement.utils.Enum.BarTableStatusEnum;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BarTableDaoImpl implements BarTableDao {
    @PersistenceContext(name = "coffee_management")

    EntityManager em;

    @Override
    public BarTable findById(Long barTableId) {
        return em.createQuery("SELECT t FROM BarTable t WHERE t.id = :barTableId", BarTable.class)
                .setParameter("barTableId", barTableId)
                .getSingleResult();
    }

    @Override
    public List<BarTable> findAll() {
        return em.createQuery("SELECT t FROM BarTable t", BarTable.class)
                .getResultList();
    }

    @Override
    public BarTable create(BarTableRequest barTableRequest) {
        BarTable barTable = new BarTable();
        if (barTableRequest.getNumber() == null) {
            return null;
        }
        barTable.setNumber(barTableRequest.getNumber());
        barTable.setNumberOfSeat(barTableRequest.getNumberOfSeat());
        barTable.setStatus(BarTableStatusEnum.AVAILABLE);

        return em.merge(barTable);
    }

    @Override
    public BarTable update(BarTableRequest barTableRequest, Long barTableId) {
        BarTable barTable = findById(barTableId);
        if (barTable == null) {
            return null;
        }
        if (barTableRequest.getNumber() != null) {
            barTable.setNumber(barTableRequest.getNumber());
        }
        if (barTableRequest.getNumberOfSeat() != null) {
            barTable.setNumberOfSeat(barTableRequest.getNumberOfSeat());
        }
        if (barTableRequest.getStatus() != null) {
                barTable.setStatus(BarTableStatusEnum.valueOf(barTableRequest.getStatus()));
        }
        return em.merge(barTable);
    }

    @Override
    public void delete(Long barTableId) {
        BarTable barTable = findById(barTableId);
        if (barTable != null) {
            em.remove(barTable);
        }
    }

    @Override
    public List<BarTable> findByStatus(BarTableStatusEnum barTableStatus) {
        return em.createQuery("SELECT t FROM BarTable t WHERE t.status = :barTableStatus", BarTable.class)
                .setParameter("barTableStatus", barTableStatus)
                .getResultList();
    }
}
