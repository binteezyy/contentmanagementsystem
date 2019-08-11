package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.User;
import com.ppt.contentmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDAO {
    @Autowired
    UserRepository userRepository;


    public User save(User usr){ return userRepository.save(usr); }


    public List<User> findAll(){ return userRepository.findAll(); }




}
