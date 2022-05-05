package com.webdev.challenge.dao;

import com.webdev.challenge.entity.Category;
import com.webdev.challenge.entity.Note;
import com.webdev.challenge.repository.CategoryRepository;
import com.webdev.challenge.repository.NoteRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NoteDAO implements INoteDAO {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Note> getNotesByCategoryId(Long categoryId) {
        Optional<Category> categoryById = categoryRepository.findById(categoryId);
        if (categoryById.isPresent()) {
            return noteRepository.getNotesByCategoryId(categoryId);
        }
        return Collections.emptyList();
    }

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }
}
