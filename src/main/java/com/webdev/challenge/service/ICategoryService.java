package com.webdev.challenge.service;

import com.webdev.challenge.dto.CategoryDTO;
import com.webdev.challenge.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getCategories();

    CategoryDTO saveCategory(Category note);

    ResponseEntity<String> deleteCategory(Long categoryId);
}
