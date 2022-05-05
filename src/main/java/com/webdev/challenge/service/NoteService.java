package com.webdev.challenge.service;

import com.webdev.challenge.dao.NoteDAO;
import com.webdev.challenge.entity.Note;
import com.webdev.challenge.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteDAO noteDAO;

    public List<Note> getNotesByCategoryId(Long categoryId) {
        return noteDAO.getNotesByCategoryId(categoryId);
    }

    public List<Note> getNotes() {
        return noteDAO.getNotes();
    }

    public Note saveNote(Note note) {
        return noteDAO.saveNote(note);
    }

    public Note updateNote(Note note) {
        return noteDAO.updateNote(note);
    }

    public void deleteNote(Long noteId) {
        noteDAO.deleteNote(noteId);
    }
}
