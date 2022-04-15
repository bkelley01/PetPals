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

    // verified functionality using Postman compared to query in pgAdmin, IS 4/15
    @GetMapping (path = "/pets/{username}")
    public List<Pet> getPetsByUserName(@PathVariable String username) {
        return this.petDao.getPetsByUsername(username);
    }

    // post to add pet -
    @PostMapping (path = "pets/add-pet")
    public void addPet(@RequestBody Pet petToAdd, String username) {
        this.petDao.addPet(petToAdd, username);
    }

    // put to deactivate pet - verified functionality using Postman to Postgres, IS 4/15
    @PutMapping (path = "pets/{username}/change-status/{petId}")
    public void deactivatePet(@PathVariable long petId, @PathVariable String username) {
        this.petDao.deactivatePet(petId, username);
    }

}
