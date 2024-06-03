package com.springmvcproject.stickynotes.controller;


import org.springframework.ui.Model;
import com.springmvcproject.stickynotes.model.dto.AddNoteDto;
import com.springmvcproject.stickynotes.model.dto.NoteDto;
import com.springmvcproject.stickynotes.model.dto.StickyNoteDto;
import com.springmvcproject.stickynotes.model.entity.Note;
import com.springmvcproject.stickynotes.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

@GetMapping("/delete/{id}/{stickyNoteId}")
    public String deleteNote(@PathVariable Long id , @PathVariable("stickyNoteId") Long stickyNoteId ) {

        this.noteService.delete(id);
        return "redirect:/sticky-note/"+stickyNoteId;

}


@GetMapping("/my-notes")
public String getNotes(Model model) {

    List<NoteDto> NoteList =this.noteService.getNotes();
    model.addAttribute("notes",NoteList);
    return "my-notes";
}

}
