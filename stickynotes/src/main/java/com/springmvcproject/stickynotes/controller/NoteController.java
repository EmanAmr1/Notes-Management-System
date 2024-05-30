package com.springmvcproject.stickynotes.controller;


import com.springmvcproject.stickynotes.model.dto.AddNoteDto;
import com.springmvcproject.stickynotes.model.dto.NoteDto;
import com.springmvcproject.stickynotes.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


}
