package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.Playdate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class JdbcPlaydateDao {

    public List<Playdate> getPlaydateByUsername(String username) {
        return null;
    }

    public List<Playdate> getPlaydatesByPersonality(String username) {
        return null;
    }

    public List<Playdate> getPlaydatesByLocation(String location) {
        return null;
    }

    public List<Playdate> getPlaydatesBetweenTimes(LocalDate date, LocalTime startTime, LocalTime endTime) {
        return null;
    }

    public List<Playdate> getPlaydateByPetId(long petId) {
        return null;
    }

    public List<Pet> getAttendeesByPlaydateId(long playdateId) {
        return null;
    }

}
