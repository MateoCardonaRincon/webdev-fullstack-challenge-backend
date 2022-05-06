package com.webdev.challenge.service;

import com.webdev.challenge.dto.NoteDTO;
import com.webdev.challenge.entity.Note;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface INoteService {

    List<NoteDTO> getNotes();

    List<Note> getNotesByCategoryId(Long categoryId);

    NoteDTO saveNote(Note note);

    NoteDTO updateNote(Note note);

    ResponseEntity<String> deleteNote(Long noteId);
}
