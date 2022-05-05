package com.webdev.challenge.dao;

import com.webdev.challenge.entity.Category;

import java.util.List;

public interface ICategoryDAO {

    List<Category> getCategories();

    Category saveCategory(Category note);

    void deleteCategory(Long categoryId);
}
