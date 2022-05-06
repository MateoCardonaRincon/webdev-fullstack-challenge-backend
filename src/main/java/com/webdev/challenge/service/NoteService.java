package com.webdev.challenge.service;

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

@Service
public class NoteService implements INoteService {

//    @Autowired
//    private ModelMapper mapper;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    @Override
    public List<Note> getNotesByCategoryId(Long categoryId) {
        return null;
    }

    public Note saveNote(Note note) {
        Optional<Category> addToCategory = categoryRepository.findById(note.getFkCategoryId());
        if (addToCategory.isPresent() && (note.getTitle() != null) && (note.getMessage() != null)) {
            addToCategory.get().addNote(note);
            Note savedNote = noteRepository.save(note);
            categoryRepository.save(addToCategory.get());
            return savedNote;
        }
        return null;
    }

    public Note updateNote(Note note) {
        Optional<Category> updateInCategory = categoryRepository.findById(note.getFkCategoryId());
        if (updateInCategory.isPresent() && note.getId() != null && note.getTitle() != null
                && note.getMessage() != null) {
            return noteRepository.save(note);
        }
        return null;
    }

    public ResponseEntity<String> deleteNote(Long noteId) {
        Optional<Note> noteById = noteRepository.findById(noteId);
        if (noteById.isPresent()) {
            noteRepository.deleteById(noteId);
            return new ResponseEntity<>("Note deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The Id of the specified note does note exist", HttpStatus.BAD_REQUEST);
    }
}
