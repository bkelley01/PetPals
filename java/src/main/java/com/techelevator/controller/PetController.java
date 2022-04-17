package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping (path = "/pets")
    public void addPet(@RequestBody Pet petToAdd, Principal principal) {
        this.petDao.addPet(petToAdd, principal.getName());
    }

    // put to deactivate pet -
    @PutMapping (path = "/pets/{petId}")
    public void updatePet(@PathVariable long petId, Principal principal) {
        this.petDao.deactivatePet(petId, principal.getName());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping (path = "/pet-playdate/{petId}/{playdateId}")
    public void addPetToPlayDate(@PathVariable long petId, @PathVariable long playdateId) {
        this.petDao.addPetToPlayDate(petId, playdateId);
    }

    @GetMapping (path = "/pets")
    public List<Pet> getAllPets() {
        return this.petDao.getAllPets();
    }

}
