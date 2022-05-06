package com.webdev.challenge.service;

import com.webdev.challenge.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryService {
    List<Category> getCategories();

    Category saveCategory(Category note);

    ResponseEntity<String> deleteCategory(Long categoryId);
}
