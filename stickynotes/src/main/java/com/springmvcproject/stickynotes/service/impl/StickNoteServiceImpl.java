package com.springmvcproject.stickynotes.service.impl;

import com.springmvcproject.stickynotes.model.dto.AddStickNoteDto;
import com.springmvcproject.stickynotes.model.dto.StickyNoteDto;
import com.springmvcproject.stickynotes.model.entity.StickyNote;
import com.springmvcproject.stickynotes.model.enums.StickyNoteStatus;
import com.springmvcproject.stickynotes.model.mapper.StickyNoteMapper;
import com.springmvcproject.stickynotes.repository.StickyNoteRepo;
import com.springmvcproject.stickynotes.service.StickNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StickNoteServiceImpl implements StickNoteService {

    private final StickyNoteRepo stickyNoteRepo;
    private final StickyNoteMapper stickyNoteMapper;


    @Override
    public AddStickNoteDto addStickyNote(AddStickNoteDto dto) {
        StickyNote entity =this.stickyNoteMapper.toAddEntity(dto);
        entity.setStatus(StickyNoteStatus.ACTIVE);
        StickyNote savedEntity= this.stickyNoteRepo.save(entity);
         AddStickNoteDto addStickNoteDto= this.stickyNoteMapper.toAddDto(savedEntity);
        return addStickNoteDto;
    }

    @Override
    public List<StickyNoteDto> allStickyNotes() {
       List<StickyNote> all=  this.stickyNoteRepo.findAll();
       return this.stickyNoteMapper.toDtoList(all);
    }


}
