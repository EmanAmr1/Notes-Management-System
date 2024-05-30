package com.springmvcproject.stickynotes.service;

import com.springmvcproject.stickynotes.model.dto.AddNoteDto;
import com.springmvcproject.stickynotes.model.dto.NoteDto;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {

    NoteDto add(AddNoteDto dto, Long stickyNoteId);
}
