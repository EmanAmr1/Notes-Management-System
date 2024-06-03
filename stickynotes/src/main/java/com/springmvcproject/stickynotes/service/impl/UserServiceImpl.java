package com.springmvcproject.stickynotes.service.impl;

import com.springmvcproject.stickynotes.model.entity.UserEntity;
import com.springmvcproject.stickynotes.repository.UserRepo;
import com.springmvcproject.stickynotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<UserEntity> getAllUsers() {
        return this.userRepo.findAll();
    }
}
