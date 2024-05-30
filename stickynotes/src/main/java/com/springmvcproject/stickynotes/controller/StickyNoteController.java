package com.springmvcproject.stickynotes.controller;

import com.springmvcproject.stickynotes.model.dto.AddStickNoteDto;
import com.springmvcproject.stickynotes.model.dto.StickyNoteDto;
import com.springmvcproject.stickynotes.model.entity.StickyNote;
import com.springmvcproject.stickynotes.service.StickNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StickyNoteController {
private  final StickNoteService stickyNoteService ;
    @GetMapping("")
    public String home(Model model){

        List<StickyNoteDto> stickyNoteDtoList =this.stickyNoteService.allStickyNotes();
        model.addAttribute("stickyNotes",stickyNoteDtoList);
        return "home";
    }

    @GetMapping("my-notes")
    public String myNotes(){
        return "my-notes";
    }


   /* @GetMapping("sticky-note/{id}")
    public String stickyNote(@PathVariable (name = "id") Integer id){
        return "sticky-note";
    }
*/
    @GetMapping("edit-note/{id}")
    public String editNote(@PathVariable (name = "id") Long id,Model model){
        StickyNoteDto stick=  this.stickyNoteService.getStickyNote(id);
        model.addAttribute("sticky",stick);

        return "edit-note";
    }


    @PostMapping("/save")
    public String addNewStickyNote( @ModelAttribute("dto") AddStickNoteDto dto){
         this.stickyNoteService.addStickyNote(dto);
        return "redirect:/";
    }

    @GetMapping("sticky-note/{id}")
    public String getStickyNote(@PathVariable Long id,Model model ){
      StickyNoteDto stick=  this.stickyNoteService.getStickyNote(id);
        model.addAttribute("sticky",stick);
        return "sticky-note";

    }



}
