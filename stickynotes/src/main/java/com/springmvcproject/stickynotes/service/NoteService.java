package com.springmvcproject.stickynotes.service;

import com.springmvcproject.stickynotes.model.dto.AddNoteDto;
import com.springmvcproject.stickynotes.model.dto.NoteDto;
import com.springmvcproject.stickynotes.model.entity.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    NoteDto add(AddNoteDto dto, Long stickyNoteId);

    void delete(Long id);

    List<NoteDto> getALLNotes(Long stickyNoteId);

    List<NoteDto> getNotes();
}
