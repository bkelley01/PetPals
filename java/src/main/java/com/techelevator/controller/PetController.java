package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetController {

    PetDao petDao;

    public PetController(PetDao petDao) {
        this.petDao = petDao;
    }

    @GetMapping (path = "/personalities")
    public List<String> getPersonalities() {
        return this.petDao.getPersonalitiesByPetId(1);
    }

    @GetMapping (path = "/pets/{username}")
    public List<Pet> getPetsByUserName(@PathVariable String username) {
        return this.petDao.getPetsByUsername(username);
    }



}
