package com.springmvcproject.stickynotes.model.mapper;

import com.springmvcproject.stickynotes.model.dto.AddNoteDto;
import com.springmvcproject.stickynotes.model.dto.NoteDto;
import com.springmvcproject.stickynotes.model.entity.Note;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteDto toDto (Note entity);

    Note  toEntity (NoteDto dto);

    Note toAddEntity (AddNoteDto dto);

    List<Note> toEntities (List<NoteDto> DTOs);

    List<NoteDto> toDTOs (List<Note> entities);



}
