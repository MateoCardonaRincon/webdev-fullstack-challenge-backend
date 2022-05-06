package com.webdev.challenge.service;

import com.webdev.challenge.entity.Category;
import com.webdev.challenge.entity.Note;
import com.webdev.challenge.repository.CategoryRepository;
import com.webdev.challenge.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        if (category.getDescription() != null) {
            return categoryRepository.save(category);
        }
        return categoryRepository.save(category);
    }

    public ResponseEntity<String> deleteCategory(Long categoryId) {
        Optional<Category> categoryToDelete = categoryRepository.findById(categoryId);
        if (categoryToDelete.isPresent()) {
            List<Note> notes = noteRepository.getNotesByCategoryId(categoryToDelete.get().getId());
            notes.forEach(note -> noteRepository.deleteById(note.getId()));
            categoryRepository.deleteById(categoryId);
            return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The Id of the specified note does note exist", HttpStatus.BAD_REQUEST);
    }
}
