package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.util.List;

public interface PetDao {

    //TODO -- discuss if we should use userId instead of username here

    // get all pets by username
    List<Pet> getPetsByUsername(String username);

    List<String> getPersonalitiesByPetId(long petId);

    // get all pets by personality
    List<Pet> getPetsByPersonality(String personality);

    // add pet
    // TODO -- discuss if this should return a boolean
    void addPet(Pet petToAdd, String username);

    // deactivate pet
    // TODO -- discuss if this should return a boolean
    void deactivatePet(long petId, String username);

    // add pet to playdate
    void addPetToPlayDate(long petId, long playdateId);

}
