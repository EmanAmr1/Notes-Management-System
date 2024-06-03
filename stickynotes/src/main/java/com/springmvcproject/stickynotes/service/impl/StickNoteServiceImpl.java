package com.springmvcproject.stickynotes.service.impl;

import com.springmvcproject.stickynotes.model.dto.AddStickNoteDto;
import com.springmvcproject.stickynotes.model.dto.StickyNoteDto;
import com.springmvcproject.stickynotes.model.dto.UpdateStickyNoteDto;
import com.springmvcproject.stickynotes.model.entity.StickyNote;
import com.springmvcproject.stickynotes.model.enums.StickyNoteStatus;
import com.springmvcproject.stickynotes.model.mapper.StickyNoteMapper;
import com.springmvcproject.stickynotes.repository.StickyNoteRepo;
import com.springmvcproject.stickynotes.service.StickNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

   /* @Override
    public UpdateStickyNoteDto updateStickyNote(UpdateStickyNoteDto dto) {
        StickyNote entity =this.stickyNoteMapper.toUpdateEntity(dto);
        StickyNote savedEntity = this.stickyNoteRepo.save(entity);
        UpdateStickyNoteDto updateStickyNoteDto = this.stickyNoteMapper.toUpdateDto(savedEntity);
        return updateStickyNoteDto;
    }*/

    @Override
    public List<StickyNoteDto> allStickyNotes() {
       List<StickyNote> all=  this.stickyNoteRepo.findAllByStatus(StickyNoteStatus.ACTIVE);
       return this.stickyNoteMapper.toDtoList(all);
    }

    @Override
    public StickyNoteDto getStickyNote( Long id) {
       Optional<StickyNote>  stickyNote =this.stickyNoteRepo.findById(id);
        return this.stickyNoteMapper.toRespDto(stickyNote.get());
    }

    @Override
    public void update(UpdateStickyNoteDto dto, Long id) {
        StickyNote entity =this.stickyNoteMapper.toUpdateEntity(dto);
        entity.setId(id);
        StickyNote savedEntity = this.stickyNoteRepo.save(entity);
    }


}
