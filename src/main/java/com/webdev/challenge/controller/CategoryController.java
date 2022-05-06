package com.webdev.challenge.controller;

import com.webdev.challenge.dto.CategoryDTO;
import com.webdev.challenge.entity.Category;
import com.webdev.challenge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("get/categories")
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("save/category")
    public CategoryDTO saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("delete/category/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

}
