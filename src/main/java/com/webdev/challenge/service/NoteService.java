package com.webdev.challenge.service;

import com.webdev.challenge.entity.Note;
import com.webdev.challenge.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements INoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getNotesByCategoryId(Long categoryId) {
        return noteRepository.getNotesByCategoryId(categoryId);
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }
}
