package com.springmvcproject.stickynotes.model.dto;

import lombok.*;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class NoteDto {

    private long id;
    private String note;
    private Long stickyNoteId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
