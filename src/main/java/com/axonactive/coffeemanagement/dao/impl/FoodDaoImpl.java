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
        return (Food) em.createNativeQuery("SELECT * FROM food WHERE id = :foodId")
                .setParameter("foodId",foodId)
                .getSingleResult();
    }

    @Override
    public List<Food> findAll() {
        return em.createNativeQuery("SELECT * FROM food")
                .getResultList();
    }

    @Override
    public Food create(FoodRequest foodRequest) {
        Food food = new Food();
        if(foodRequest.getName()==null||foodRequest.getCurrentPrice()==null)
        {
            return null;
        }
        food.setName(foodRequest.getName());
        food.setCurrentPrice(foodRequest.getCurrentPrice());
        food.setOldPrice(foodRequest.getCurrentPrice());
        food.setCategory(categoryDao.findById(foodRequest.getCategoryRequest().getId()));
        food.setDescription(foodRequest.getDescription());
        food.setImage(foodRequest.getImage());

        return em.merge(food);
    }

    @Override
    public Food update(FoodRequest foodRequest, Long foodId) {
        Food food = findById(foodId);
        if(foodRequest.getName()!=null){
            food.setName(foodRequest.getName());
        }
        if(foodRequest.getCurrentPrice()!=null){
            food.setCurrentPrice(foodRequest.getCurrentPrice());
        }
        if(foodRequest.getOldPrice() !=null){
            food.setOldPrice(foodRequest.getOldPrice());
        }
        if(foodRequest.getCategoryRequest().getId()!=null){
            food.setCategory(categoryDao.findById(foodRequest.getCategoryRequest().getId()));
        }
        if(foodRequest.getDescription()!=null){
            food.setDescription(foodRequest.getDescription());
        }
        if(foodRequest.getImage()!=null){
            food.setImage(foodRequest.getImage());
        }

        return em.merge(food);
    }

    @Override
    public void delete(Long foodId) {
        Food food = findById(foodId);
        if(food!=null){
            em.remove(food);
        }
    }

    @Override
    public List<Food> findByCategoryId(Long categoryId) {
        return em.createNativeQuery("SELECT * FROM food WHERE category_id = :categoryId ORDER BY food_id", Food.class)
                .setParameter("categoryId",categoryId)
                .getResultList();
    }

    @Override
    public List<Food> findByName(String name) {
        return em.createNativeQuery("SELECT * FROM food WHERE name LIKE :name ORDER BY food_id",Food.class)
                .setParameter("name","%"+name+"%")
                .getResultList();
    }

    @Override
    public List<Food> findByCurrentPriceBetween(Double startPrice, Double endPrice) {
        return em.createNativeQuery("SELECT * FROM food WHERE currentprice >= :startPrice AND currentprice <= :endPrice ORDER BY food_id",Food.class)
                .setParameter("startPrice",startPrice)
                .setParameter("endPrice",endPrice)
                .getResultList();
    }

    @Override
    public List<Food> findByCurrentPriceBetweenAndCategory(Double startPrice, Double endPrice, Long categoryId) {
        return em.createNativeQuery("SELECT * FROM food WHERE currentprice >= :startPrice AND currentprice <= :endPrice AND category_id = :categoryId", Food.class)
                .setParameter("startPrice",startPrice)
                .setParameter("endPrice",endPrice)
                .setParameter("categoryId",categoryId)
                .getResultList();
    }
}
