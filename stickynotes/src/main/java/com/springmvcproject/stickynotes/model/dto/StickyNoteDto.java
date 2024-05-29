package com.springmvcproject.stickynotes.model.dto;

import com.springmvcproject.stickynotes.model.enums.StickyNoteStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StickyNoteDto {


    private long id;
    private String description;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private StickyNoteStatus status;
    private String color;

}
