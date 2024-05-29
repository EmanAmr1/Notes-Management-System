package com.springmvcproject.stickynotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StickyNoteController {

    @GetMapping("")
    public String home(){
        return "home";
    }

    @GetMapping("my-notes")
    public String test(){
        return "my-notes";
    }

}
