package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.CategoryRequest;
import com.axonactive.coffeemanagement.dao.CategoryDao;
import com.axonactive.coffeemanagement.entity.Category;
import com.axonactive.coffeemanagement.utils.Enum.CategoryTypeEnum;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext(name = "coffee_management")

    EntityManager em;

    @Override
    public Category findById(Long categoryId) {
        return em.createQuery("SELECT c FROM Category c WHERE c.id = :categoryId", Category.class)
                .setParameter("categoryId", categoryId)
                .getSingleResult();
    }

    @Override
    public List<Category> findAll() {
        return em.createQuery("SELECT c FROM Category c", Category.class)
                .getResultList();
    }

    @Override
    public Category create(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName().trim());
        if (categoryRequest.getAmount() == null) {
            category.setAmount(0);
        } else {
            category.setAmount(categoryRequest.getAmount());
        }
        category.setType(CategoryTypeEnum.valueOf(categoryRequest.getType().toUpperCase().trim()));
        return em.merge(category);
    }

    @Override
    public Category update(CategoryRequest categoryRequest, Long categoryId) {
        Category category = findById(categoryId);
        category.setName(categoryRequest.getName().trim());
        category.setAmount(categoryRequest.getAmount());
        category.setType(CategoryTypeEnum.valueOf(categoryRequest.getType().toUpperCase().trim()));
        return em.merge(category);
    }

    @Override
    public void delete(Long categoryId) {
        Category category = findById(categoryId);
        if (category != null) {
            em.remove(category);
        }
    }

    @Override
    public List<Category> findByName(String categoryName) {
        return em.createQuery("SELECT c FROM Category c WHERE c.name LIKE :categoryName", Category.class)
                .setParameter("categoryName", "%" + categoryName + "%")
                .getResultList();
    }

    @Override
    public List<Category> findByType(String categoryType) {
        return em.createQuery("SELECT c FROM Category c WHERE c.type = :categoryType", Category.class)
                .setParameter("categoryType", CategoryTypeEnum.valueOf(categoryType.toUpperCase()))
                .getResultList();
    }
}
