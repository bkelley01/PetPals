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
    private UserDao userDao;

    public JdbcPetDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }

    // get pets by username
    @Override
    public List<Pet> getPetsByUsername(String username) {
        String sql = "SELECT pet_id, pet_name, pet_type, users.user_id FROM pets" +
                " JOIN users ON pets.user_id = users.user_id" +
                " WHERE username = ? AND active = true;";
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
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT pets.pet_id, pet_name, pet_type, user_id\n" +
                "FROM pets\n" +
                "JOIN pet_personality ON pet_personality.pet_id = pets.pet_id\n" +
                "WHERE pet_personality.personality = ?;";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, personality);
        while (rs.next()) {
            pets.add(mapRowToPet(rs));
        }
        return pets;
    }

    // add a pet (including the pet personality
    @Override
    public void addPet(Pet petToAdd, String username) {
        // get the userId and add to petToAdd
        long userId = userDao.findIdByUsername(username);
        petToAdd.setUserId(userId);

        // create a pet record in database
        long petId = addPetRecord(petToAdd);

        // create pet personality records
        for (String personality : petToAdd.getPersonalities()) {
            addPetPersonalityRecord(petId, personality);
        }
    }

    // deactivate pet
    @Override
    public void deactivatePet(long petId, String username) {
        if (doesPetBelongToUser(petId, username)) {
            String sql = "UPDATE pets SET active = false\n" +
                    "WHERE pet_id = ?;";
            jdbcTemplate.update(sql, petId);
        }
    }

    @Override
    public void addPetToPlayDate(long petId, long playdateId) {
        String sql = "INSERT INTO pet_playdate (pet_id, playdate_id, acceptance_status) VALUES (?, ?, 'Accepted');";
        jdbcTemplate.update(sql, petId, playdateId);
    }

    private Pet mapRowToPet(SqlRowSet rs) {
        Pet pet = new Pet();
        pet.setPetId(rs.getLong("pet_id"));
        pet.setPetName(rs.getString("pet_name"));
        pet.setPetType(rs.getString("pet_type"));
        pet.setUserId(rs.getLong("user_id"));
        pet.setPersonalities(getPersonalitiesByPetId(pet.getPetId()));
        return pet;
    }

    private long addPetRecord(Pet petToAdd) {
        String sql = "INSERT INTO pets (pet_name, pet_type, user_id, active)\n" +
                "VALUES (?, ?, ?, true) RETURNING pet_id;";
        Long petId = jdbcTemplate.queryForObject(
                sql,
                Long.class,
                petToAdd.getPetName(),
                petToAdd.getPetType(),
                petToAdd.getUserId()
        );
        return petId;
    }

    private void addPetPersonalityRecord(long petId, String personality) {
        String sql = "INSERT INTO pet_personality (pet_id, personality) VALUES (?, ?);";
        jdbcTemplate.update(sql, petId, personality);
    }

    // TODO -- discuss if this should be a public method (and added to interface)
    private boolean doesPetBelongToUser(long petId, String username) {
        Long expectedUserId = (long)userDao.findIdByUsername(username);
        String sql = "SELECT user_id FROM pets WHERE pet_id = ?;";
        Long actualUserId = jdbcTemplate.queryForObject(sql, Long.class, petId);
        return expectedUserId.equals(actualUserId);
    }

    public List<Pet> getAllPets() {
        /*String sql = "SELECT pet_id, pet_name, pet_type, user_id" +
                        " FROM pets" +
                        " WHERE active = true;";*/
        String sql = "SELECT pet_id, pet_name, pet_type, users.user_id, users.username" +
                " FROM pets" +
                " JOIN users ON pets.user_id = users.user_id" +
                " WHERE active = true;";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        List<Pet> results = new ArrayList<>();
        while (rs.next()) {
            Pet pet = mapRowToPet(rs);
            pet.setUsername(rs.getString("username"));
            results.add(pet);
        }
        return results;
    }

}
