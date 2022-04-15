package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.Playdate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class JdbcPlaydateDao implements PlaydateDao{
    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;

    public JdbcPlaydateDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }

    @Override
    public List<Playdate> getPlaydatesByUsername(String username) {
        return null;
    }

    @Override
    public List<Playdate> getPlaydatesByPersonality(String username) {
        return null;
    }

    @Override
    public List<Playdate> getPlaydatesByLocation(String location) {
        return null;
    }

    @Override
    public List<Playdate> getPlaydatesBetweenTimes(LocalDate date, LocalTime startTime, LocalTime endTime) {
        return null;
    }

    @Override
    public List<Playdate> getPlaydateByPetId(long petId) {
        return null;
    }

    @Override
    public List<Pet> getAttendeesByPlaydateId(long playdateId) {
        return null;
    }

}
