package com.webdev.challenge.service;

import com.webdev.challenge.entity.Note;

import java.util.List;

public interface INoteService {

    List<Note> getNotesByCategoryId(Long categoryId);

    Note saveNote(Note note);

    Note updateNote(Note note);

    void deleteNote(Long noteId);
}
