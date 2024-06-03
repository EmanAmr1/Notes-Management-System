package com.springmvcproject.stickynotes.controller;

import com.springmvcproject.stickynotes.model.dto.AddStickNoteDto;
import com.springmvcproject.stickynotes.model.dto.NoteDto;
import com.springmvcproject.stickynotes.model.dto.StickyNoteDto;
import com.springmvcproject.stickynotes.model.dto.UpdateStickyNoteDto;
import com.springmvcproject.stickynotes.model.entity.Note;
import com.springmvcproject.stickynotes.service.NoteService;
import com.springmvcproject.stickynotes.service.StickNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StickyNoteController {
private  final StickNoteService stickyNoteService ;
private final NoteService noteService;
    @GetMapping("")
    public String home(Model model){

        List<StickyNoteDto> stickyNoteDtoList =this.stickyNoteService.allStickyNotes();
        model.addAttribute("stickyNotes",stickyNoteDtoList);
        return "home";
    }

   /* @GetMapping("my-notes")
    public String myNotes(){

        return "my-notes";
    }*/


   /* @GetMapping("sticky-note/{id}")
    public String stickyNote(@PathVariable (name = "id") Integer id){
        return "sticky-note";
    }
*/


    @GetMapping("sticky-note/{id}")
    public String getStickyNote(@PathVariable Long id,Model model ){
        StickyNoteDto stick=  this.stickyNoteService.getStickyNote(id);
        List<NoteDto> allNotes =this.noteService.getALLNotes(id);
        model.addAttribute("sticky",stick);
        model.addAttribute("notes", allNotes);
        return "sticky-note";

    }

    @PostMapping("/save")
    public String addNewStickyNote( @ModelAttribute("dto") AddStickNoteDto dto){
         this.stickyNoteService.addStickyNote(dto);
        return "redirect:/";
    }

    @GetMapping("edit-note/{id}")
    public String editNote(@PathVariable (name = "id") Long id,Model model){
        StickyNoteDto stick=  this.stickyNoteService.getStickyNote(id);
        model.addAttribute("sticky",stick);
        return "edit-note";
    }

    @PostMapping("/update/{id}")
    public String updateStickyNote(@ModelAttribute("dto") UpdateStickyNoteDto dto , @PathVariable("id") Long id){
        this.stickyNoteService.update(dto,id);
        return "redirect:/";
    }







}
