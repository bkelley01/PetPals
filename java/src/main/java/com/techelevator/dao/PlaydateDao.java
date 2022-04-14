package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.Playdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface PlaydateDao {

    List<Playdate> getPlaydateByUsername(String username);

    List<Playdate> getPlaydatesByPersonality(String username);

    List<Playdate> getPlaydatesByLocation(String location);

    List<Playdate> getPlaydatesBetweenTimes(LocalDate date, LocalTime startTime, LocalTime endTime);

    List<Playdate> getPlaydateByPetId(long petId);

    List<Pet> getAttendeesByPlaydateId(long playdateId);

}
