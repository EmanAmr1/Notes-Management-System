package com.springmvcproject.stickynotes.service;

import com.springmvcproject.stickynotes.model.dto.AddStickNoteDto;
import com.springmvcproject.stickynotes.model.dto.StickyNoteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StickNoteService {

    public AddStickNoteDto addStickyNote(AddStickNoteDto dto);
    List<StickyNoteDto> allStickyNotes();

   StickyNoteDto getStickyNote(Long id);
}
