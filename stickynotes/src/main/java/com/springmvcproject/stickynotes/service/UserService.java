package com.springmvcproject.stickynotes.service;

import com.springmvcproject.stickynotes.model.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserEntity> getAllUsers();
}
