package com.springmvcproject.stickynotes.model.mapper;

import com.springmvcproject.stickynotes.model.dto.StickyNoteDto;
import com.springmvcproject.stickynotes.model.entity.StickyNote;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StickyNoteMapper {

StickyNoteDto toRespDto(StickyNote entity);
StickyNote toEntity(StickyNoteDto dto);
List<StickyNoteDto> toEntities (StickyNote dto);
List<StickyNote> toDtos (StickyNoteDto entity);
}
