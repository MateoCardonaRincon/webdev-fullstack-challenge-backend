package com.webdev.challenge.controller;

import com.webdev.challenge.dto.NoteDTO;
import com.webdev.challenge.entity.Note;
import com.webdev.challenge.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("get/notes/{categoryId}")
    public List<Note> getNotesByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return noteService.getNotesByCategoryId(categoryId);
    }

    @GetMapping("get/notes")
    public List<NoteDTO> getNotes() {
        return noteService.getNotes();
    }

    @PostMapping("save/note")
    public NoteDTO saveNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    @PutMapping("update/note")
    public NoteDTO updateNote(@RequestBody Note note) {
        return noteService.updateNote(note);
    }

    @DeleteMapping("delete/note/{noteId}")
    public ResponseEntity<String> deleteNote(@PathVariable("noteId") Long noteId) {
        return noteService.deleteNote(noteId);
    }

}
