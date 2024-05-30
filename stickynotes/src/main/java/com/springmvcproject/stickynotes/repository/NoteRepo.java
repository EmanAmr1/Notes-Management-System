package com.springmvcproject.stickynotes.repository;

import com.springmvcproject.stickynotes.model.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note,Long> {
}
