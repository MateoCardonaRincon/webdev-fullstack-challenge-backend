package com.webdev.challenge.dao;

import com.webdev.challenge.entity.Note;

import java.util.List;

public interface INoteDAO {

    List<Note> getNotesByCategoryId(Long categoryId);

    List<Note> getNotes();

    Note saveNote(Note note);

    Note updateNote(Note note);

    void deleteNote(Long noteId);
}
