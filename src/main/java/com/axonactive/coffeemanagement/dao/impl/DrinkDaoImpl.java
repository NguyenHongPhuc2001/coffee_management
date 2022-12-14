package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.DrinkRequest;
import com.axonactive.coffeemanagement.dao.CategoryDao;
import com.axonactive.coffeemanagement.dao.DrinkDao;
import com.axonactive.coffeemanagement.entity.Drink;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DrinkDaoImpl implements DrinkDao {

    @PersistenceContext(name = "coffee_management")

    EntityManager em;

    @Inject
    private CategoryDao categoryDao;

    @Override
    public Drink findById(Long drinkId) {
        return em.createQuery("SELECT d FROM Drink d WHERE d.id = :drinkId", Drink.class)
                .setParameter("drinkId", drinkId)
                .getSingleResult();
    }

    @Override
    public List<Drink> findAll() {
        return em.createQuery("SELECT d FROM Drink d", Drink.class)
                .getResultList();
    }

    @Override
    public Drink create(DrinkRequest drinkRequest) {
        Drink drink = new Drink();
        drink.setName(drinkRequest.getName().trim());
        drink.setImage(drinkRequest.getImage().trim());
        drink.setPrice(drinkRequest.getPrice());
        drink.setDescription(drinkRequest.getDescription().trim());
        drink.setCategory(categoryDao.findById(drinkRequest.getCategoryRequest().getId()));
        return em.merge(drink);
    }

    @Override
    public Drink update(DrinkRequest drinkRequest, Long drinkId) {
        Drink drink = findById(drinkId);
        drink.setName(drinkRequest.getName().trim());
        drink.setDescription(drinkRequest.getDescription().trim());
        drink.setPrice(drinkRequest.getPrice());
        drink.setImage(drinkRequest.getImage().trim());
        drink.setCategory(categoryDao.findById(drinkRequest.getCategoryRequest().getId()));
        return em.merge(drink);
    }

    @Override
    public void delete(Long drinkId) {
        Drink drink = findById(drinkId);
        if (drink != null) {
            em.remove(drink);
        }
    }

    @Override
    public List<Drink> findByCategoryId(Long categoryId) {
        return em.createQuery("SELECT d FROM Drink d WHERE d.category.id = :categoryId", Drink.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    @Override
    public List<Drink> findByName(String name) {
        return em.createQuery("SELECT d FROM Drink d WHERE d.name LIKE :name", Drink.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    public List<Drink> findByCurrentPriceBetween(Double startPrice, Double endPrice) {
        return em.createQuery("SELECT d FROM Drink d WHERE d.price >= :startPrice AND d.price <= :endPrice", Drink.class)
                .setParameter("startPrice", startPrice)
                .setParameter("endPrice", endPrice)
                .getResultList();
    }

    @Override
    public List<Drink> findByCurrentPriceBetweenAndCategory(Double startPrice, Double endPrice, Long categoryId) {
        return em.createQuery("SELECT d FROM Drink d WHERE d.price >= :startPrice AND d.price <= :endPrice AND d.category.id = :categoryId", Drink.class)
                .setParameter("startPrice", startPrice)
                .setParameter("endPrice", endPrice)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }
}
