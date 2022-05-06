package com.webdev.challenge.service;

import com.webdev.challenge.dto.NoteDTO;
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
public class NoteService implements INoteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<NoteDTO> getNotes() {
        List<Note> noteList = noteRepository.findAll();
        return noteList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Note> getNotesByCategoryId(Long categoryId) {
        return noteRepository.getNotesByCategoryId(categoryId);
    }

    public NoteDTO saveNote(Note note) {
        Optional<Category> addToCategory = categoryRepository.findById(note.getFkCategoryId());
        if (addToCategory.isPresent() && (note.getTitle() != null) && (note.getMessage() != null)) {
            addToCategory.get().addNote(note);
            Note savedNote = noteRepository.save(note);
            categoryRepository.save(addToCategory.get());
            return mapToDTO(savedNote);
        }
        return null;
    }

    public NoteDTO updateNote(Note note) {
        Optional<Category> updateInCategory = categoryRepository.findById(note.getFkCategoryId());
        if (updateInCategory.isPresent() && note.getId() != null && note.getTitle() != null
                && note.getMessage() != null) {
            return mapToDTO(noteRepository.save(note));
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

    private NoteDTO mapToDTO(Note note) {
        return modelMapper.map(note, NoteDTO.class);
    }

    private Note mapToEntity(NoteDTO noteDTO) {
        return modelMapper.map(noteDTO, Note.class);
    }
}
