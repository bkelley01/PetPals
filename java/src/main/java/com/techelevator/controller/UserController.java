package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class UserController<Users> {

    UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return this.userDao.findAll();
    }

    @GetMapping(path = "/users/{petId}")
    public String getUsernameByPetId(@PathVariable long petId) {return this.userDao.getUsernameByPetId(petId); }

}
