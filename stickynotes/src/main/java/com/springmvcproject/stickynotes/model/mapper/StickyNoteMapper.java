package com.springmvcproject.stickynotes.model.mapper;

import com.springmvcproject.stickynotes.model.dto.AddStickNoteDto;
import com.springmvcproject.stickynotes.model.dto.StickyNoteDto;
import com.springmvcproject.stickynotes.model.dto.UpdateStickyNoteDto;
import com.springmvcproject.stickynotes.model.entity.StickyNote;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StickyNoteMapper {

StickyNoteDto toRespDto(StickyNote entity);
StickyNote toEntity(StickyNoteDto dto);
    List<StickyNoteDto> toDtoList(List<StickyNote> entities);

    List<StickyNote> toEntityList(List<StickyNoteDto> dtos);

AddStickNoteDto toAddDto(StickyNote entity);

StickyNote toAddEntity(AddStickNoteDto dto);

    UpdateStickyNoteDto toUpdateDto (StickyNote entity);

    StickyNote toUpdateEntity (UpdateStickyNoteDto dto);



}
