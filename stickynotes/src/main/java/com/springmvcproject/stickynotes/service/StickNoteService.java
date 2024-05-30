package com.springmvcproject.stickynotes.service;

import com.springmvcproject.stickynotes.model.dto.AddStickNoteDto;
import com.springmvcproject.stickynotes.model.dto.StickyNoteDto;
import com.springmvcproject.stickynotes.model.dto.UpdateStickyNoteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StickNoteService {

    List<StickyNoteDto> allStickyNotes();

   StickyNoteDto getStickyNote(Long id);


    public AddStickNoteDto addStickyNote(AddStickNoteDto dto);

    //public UpdateStickyNoteDto updateStickyNote(UpdateStickyNoteDto dto);


    void update(UpdateStickyNoteDto dto, Long id);

}
