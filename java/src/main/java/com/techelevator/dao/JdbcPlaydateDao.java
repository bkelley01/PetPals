package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.Playdate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
        String sql = "SELECT playdates.playdate_id, " +
                        "playdates.playdate_title, " +
                        "playdates.playdate_location, " +
                        "playdates.play_date, " +
                        "playdates.start_time, " +
                        "playdates.end_time, " +
                        "users.username, " +
                        "playdates.active " +
                     "FROM pet_playdate " +
                        "JOIN playdates ON playdates.playdate_id = pet_playdate.playdate_id " +
                        "JOIN users ON users.user_id = playdates.host_id " +
                     "WHERE pet_id IN ( " +
                        "SELECT pet_id FROM pets " +
                            "JOIN users ON users.user_id = pets.user_id " +
                        "WHERE users.username = ?);";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
        List<Playdate> playdates = new ArrayList<>();
        while (rowSet.next()) {
            Playdate playdate = mapRowToPlaydate(rowSet);
            playdates.add(playdate);
        }

        return playdates;
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
    public List<String> getAttendeesByPlaydateId(long playdateId) {
        String sql = "SELECT pets.pet_name FROM pet_playdate " +
                        "JOIN pets ON pets.pet_id = pet_playdate.pet_id " +
                     "WHERE playdate_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, playdateId);
        List<String> attendees = new ArrayList<>();

        while (rowSet.next()) {
            attendees.add(rowSet.getString("pet_name"));
        }

        return attendees;
    }


    private Playdate mapRowToPlaydate(SqlRowSet rs) {
        Playdate playdate = new Playdate();
        playdate.setPlaydateId(rs.getLong("playdate_id"));
        playdate.setTitle(rs.getString("playdate_title"));
        playdate.setLocation(rs.getString("playdate_location"));
        playdate.setDate(rs.getDate("play_date").toLocalDate());
        playdate.setStartTime(rs.getTime("start_time").toLocalTime());
        playdate.setEndTime(rs.getTime("end_time").toLocalTime());
        playdate.setAttendees(getAttendeesByPlaydateId(playdate.getPlaydateId()));
        playdate.setHost(rs.getString("username"));
        playdate.setActive(rs.getBoolean("active"));

        return playdate;
    }
}
