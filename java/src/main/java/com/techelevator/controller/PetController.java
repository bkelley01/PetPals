package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class PetController {

    PetDao petDao;

    public PetController(PetDao petDao) {
        this.petDao = petDao;
    }

//    @GetMapping (path = "/personalities")
//    public List<String> getPersonalities() {
//        return this.petDao.getPersonalitiesByPetId(1);
//    }

    @GetMapping (path = "/pets/{username}")
    public List<Pet> getPetsByUserName(@PathVariable String username) {
        return this.petDao.getPetsByUsername(username);
    }

    @PostMapping (path = "pets/add-pet")
    public void addPet(@RequestBody Pet petToAdd, String username) {
        this.petDao.addPet(petToAdd, username);
    }



}
