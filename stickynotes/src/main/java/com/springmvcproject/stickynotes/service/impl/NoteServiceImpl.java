package com.springmvcproject.stickynotes.service.impl;

import com.springmvcproject.stickynotes.model.dto.AddNoteDto;
import com.springmvcproject.stickynotes.model.dto.NoteDto;
import com.springmvcproject.stickynotes.model.entity.Note;
import com.springmvcproject.stickynotes.model.mapper.NoteMapper;
import com.springmvcproject.stickynotes.repository.NoteRepo;
import com.springmvcproject.stickynotes.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {

private final NoteRepo noteRepo;
private final NoteMapper noteMapper;

    @Override
    public NoteDto add(AddNoteDto dto, Long stickyNoteId) {

          Note entity = this.noteMapper.toAddEntity(dto);
          entity.setStickyNoteId(stickyNoteId);
          Note savedEntity =this.noteRepo.save(entity);
          return this.noteMapper.toDto(savedEntity);
    }
}
