package com.springmvcproject.stickynotes.controller;

import org.springframework.ui.Model;
import com.springmvcproject.stickynotes.model.entity.UserEntity;
import com.springmvcproject.stickynotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String index(Model model){
        List<UserEntity> user =userService.getAllUsers();
        model.addAttribute("users",user);
        return "users";
    }
}
