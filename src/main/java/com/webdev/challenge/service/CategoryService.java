package com.webdev.challenge.service;

import com.webdev.challenge.dao.CategoryDAO;
import com.webdev.challenge.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    public List<Category> getCategories() {
        return categoryDAO.getCategories();
    }

    public Category saveCategory(Category category) {
        return categoryDAO.saveCategory(category);
    }

    public void deleteCategory(Long categoryId) {
        categoryDAO.deleteCategory(categoryId);
    }
}
