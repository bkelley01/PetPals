package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.Playdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface PlaydateDao {
    //TODO -- discuss if we should use userId instead of username here

    List<Playdate> getPlaydatesByUsername(String username);

    List<Playdate> getPlaydatesByPersonality(String username);

    List<Playdate> getPlaydatesByLocation(String location);

    List<Playdate> getPlaydatesBetweenTimes(LocalDate date, LocalTime startTime, LocalTime endTime);

    List<Playdate> getPlaydateByPetId(long petId);

    List<String> getAttendeesByPlaydateId(long playdateId);

    void createPlaydate(Playdate playdate, String username);

}
