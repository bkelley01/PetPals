package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    // post to add pet
    @PostMapping (path = "/pets")
    public void addPet(@RequestBody Pet petToAdd, Principal principal) {
        this.petDao.addPet(petToAdd, principal.getName());
    }

    // put to deactivate pet -
    @PutMapping (path = "/pets/{petId}")
    public void deactivatePet(@PathVariable long petId, Principal principal) {
        this.petDao.deactivatePet(petId, principal.getName());
    }

}
