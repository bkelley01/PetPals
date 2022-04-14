package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.util.List;

public interface PetDao {

    // get all pets by username
    List<Pet> getPetsByUsername(String username);

    List<String> getPersonalitiesByPetId(long petId);

    // get all pets by personality
    List<Pet> getPetsByPersonality(String personality);

    // add pet
    void addPet(Pet petToAdd, String username);

    // deactivate pet
    void deactivatePet(long petId, String username);

}
