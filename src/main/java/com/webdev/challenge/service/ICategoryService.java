package com.webdev.challenge.service;

import com.webdev.challenge.entity.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getCategories();

    Category saveCategory(Category note);

    void deleteCategory(Long categoryId);
}