package com.webdev.challenge.controller;

import com.webdev.challenge.entity.Category;
import com.webdev.challenge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("get/categories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("save/category")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("delete/category/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
    }

}
