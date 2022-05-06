package com.webdev.challenge.service;

import com.webdev.challenge.dto.CategoryDTO;
import com.webdev.challenge.entity.Category;
import com.webdev.challenge.entity.Note;
import com.webdev.challenge.repository.CategoryRepository;
import com.webdev.challenge.repository.NoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    public List<CategoryDTO> getCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CategoryDTO saveCategory(Category category) {
        if (category.getDescription() != null) {
            return mapToDTO(categoryRepository.save(category));
        }
        return null;
    }

    public ResponseEntity<String> deleteCategory(Long categoryId) {
        Optional<Category> categoryToDelete = categoryRepository.findById(categoryId);

        if (categoryToDelete.isPresent()) {
            List<Note> notes = noteRepository.getNotesByCategoryId(categoryId);
            notes.forEach(note -> noteRepository.deleteById(note.getId()));
            categoryRepository.deleteById(categoryId);
            return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The Id of the specified note does not exist", HttpStatus.BAD_REQUEST);
    }

    private CategoryDTO mapToDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    private Category mapToEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, Category.class);
    }
}
