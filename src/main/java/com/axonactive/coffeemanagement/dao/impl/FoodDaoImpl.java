package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.FoodRequest;
import com.axonactive.coffeemanagement.dao.CategoryDao;
import com.axonactive.coffeemanagement.dao.FoodDao;
import com.axonactive.coffeemanagement.entity.Food;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class FoodDaoImpl implements FoodDao {

    @PersistenceContext(name = "coffee_management")

    EntityManager em;

    @Inject
    private CategoryDao categoryDao;

    @Override
    public Food findById(Long foodId) {
        return (Food) em.createQuery("SELECT f FROM Food f WHERE f.id = :foodId")
                .setParameter("foodId", foodId)
                .getSingleResult();
    }

    @Override
    public List<Food> findAll() {
        return em.createQuery("select F from Food f", Food.class)
                .getResultList();
    }

    @Override
    public Food create(FoodRequest foodRequest) {
        Food food = new Food();
        food.setName(foodRequest.getName().trim());
        food.setPrice(foodRequest.getPrice());
        food.setCategory(categoryDao.findById(foodRequest.getCategoryRequest().getId()));
        food.setDescription(foodRequest.getDescription().trim());
        food.setImage(foodRequest.getImage().trim());
        return em.merge(food);
    }

    @Override
    public Food update(FoodRequest foodRequest, Long foodId) {
        Food food = findById(foodId);
        food.setName(foodRequest.getName().trim());
        food.setPrice(foodRequest.getPrice());
        food.setCategory(categoryDao.findById(foodRequest.getCategoryRequest().getId()));
        food.setDescription(foodRequest.getDescription().trim());
        food.setImage(foodRequest.getImage().trim());
        return em.merge(food);
    }

    @Override
    public void delete(Long foodId) {
        Food food = findById(foodId);
        if (food != null) {
            em.remove(food);
        }
    }

    @Override
    public List<Food> findByCategoryId(Long categoryId) {
        return em.createQuery("SELECT F FROM Food f WHERE f.category.id = :categoryId ORDER BY f.id", Food.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    @Override
    public List<Food> findByName(String name) {
        return em.createQuery("SELECT f FROM Food f WHERE f.name LIKE :name ORDER BY f.id", Food.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    public List<Food> findByCurrentPriceBetween(Double startPrice, Double endPrice) {
        return em.createQuery("SELECT f FROM Food f WHERE f.price >= :startPrice AND f.price <= :endPrice ORDER BY f.id", Food.class)
                .setParameter("startPrice", startPrice)
                .setParameter("endPrice", endPrice)
                .getResultList();
    }

    @Override
    public List<Food> findByCurrentPriceBetweenAndCategory(Double startPrice, Double endPrice, Long categoryId) {
        return em.createQuery("SELECT f FROM Food f WHERE f.price >= :startPrice AND f.price <= :endPrice AND f.category.id = :categoryId", Food.class)
                .setParameter("startPrice", startPrice)
                .setParameter("endPrice", endPrice)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }
}
