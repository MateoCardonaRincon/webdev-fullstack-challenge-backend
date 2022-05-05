package com.webdev.challenge.repository;

import com.webdev.challenge.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT n FROM Note n WHERE n.fkCategoryId = :categoryId")
    List<Note> getNotesByCategoryId(@Param("categoryId") Long categoryId);
}
