package com.webdev.challenge.service;

import com.webdev.challenge.entity.Note;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface INoteService {

    List<Note> getNotes();

    List<Note> getNotesByCategoryId(Long categoryId);

    Note saveNote(Note note);

    Note updateNote(Note note);

    ResponseEntity<String> deleteNote(Long noteId);
}
