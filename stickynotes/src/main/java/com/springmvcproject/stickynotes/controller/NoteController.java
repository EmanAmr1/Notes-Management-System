package com.springmvcproject.stickynotes.controller;


import com.springmvcproject.stickynotes.model.dto.AddNoteDto;
import com.springmvcproject.stickynotes.model.dto.NoteDto;
import com.springmvcproject.stickynotes.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
@AllArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/add/{stickyNoteId}")
    public String addNote(@ModelAttribute("dto") AddNoteDto dto ,
                          @PathVariable("stickyNoteId") Long stickyNoteId){
        this.noteService.add(dto,stickyNoteId);
  return "redirect:/sticky-note/"+stickyNoteId;

    }

}
