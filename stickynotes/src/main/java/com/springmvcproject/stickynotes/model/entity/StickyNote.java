package com.springmvcproject.stickynotes.model.entity;

import com.springmvcproject.stickynotes.model.enums.StickyNoteStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name = "sticky-note")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StickyNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sticky-note-id")
    private long id;
    private String description;
    private String name;
    @CreationTimestamp
    @Column(name = "deleted_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private StickyNoteStatus status;
    private  String color;

}
