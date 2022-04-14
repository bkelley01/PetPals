package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetDao implements PetDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // get pets by username
    @Override
    public List<Pet> getPetsByUsername(String username) {
        String sql = "SELECT pet_id, pet_name, pet_type, users.user_id FROM pets" +
                " JOIN users ON pets.user_id = users.user_id" +
                " WHERE username = ?;";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, username);
        List<Pet> pets = new ArrayList<>();
        while (rs.next()) {
            Pet pet = mapRowToPet(rs);
            pets.add(pet);
        }
        return pets;
    }

    @Override
    public List<String> getPersonalitiesByPetId(long petId) {
        String sql = "SELECT personality FROM pet_personality WHERE pet_id = ?;";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, petId);
        List<String> personalities = new ArrayList<>();
        while (rs.next()) {
            personalities.add(rs.getString("personality"));
        }
        return personalities;
    }

    // get all pets by personality
    @Override
    public List<Pet> getPetsByPersonality(String personality) {
        return null;
    }

    // add pet
    @Override
    public void addPet(Pet petToAdd, String username) {

    }

    // deactivate pet
    @Override
    public void deactivatePet(long petId, String username) {
    }

    private Pet mapRowToPet(SqlRowSet rs) {
        Pet pet = new Pet();
        pet.setPetId(rs.getLong("pet_id"));
        pet.setPetName(rs.getString("pet_name"));
        pet.setAnimalType(rs.getString("pet_type"));
        pet.setUserId(rs.getLong("user_id"));
        pet.setPersonalities(getPersonalitiesByPetId(pet.getPetId()));
        return pet;
    }

}
