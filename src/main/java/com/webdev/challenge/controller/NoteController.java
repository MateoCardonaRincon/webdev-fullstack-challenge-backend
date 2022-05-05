package com.webdev.challenge.controller;

import com.webdev.challenge.entity.Note;
import com.webdev.challenge.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("get/notes/{categoryId}")
    public List<Note> getNotesByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return noteService.getNotesByCategoryId(categoryId);
    }

    @PostMapping("save/note")
    public Note saveNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    @PutMapping("update/note")
    public Note updateNote(@RequestBody Note note) {
        return noteService.updateNote(note);
    }

    @DeleteMapping("delete/note/{noteId}")
    public void deleteNote(@PathVariable("noteId") Long noteId) {
        noteService.deleteNote(noteId);
    }

}
