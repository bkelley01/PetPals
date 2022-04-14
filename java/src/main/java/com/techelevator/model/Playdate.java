package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

public class Playdate {

    private long playdateId;
    private String location;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<Long> attendees;
    private long host;

    public long getPlaydateId() {
        return playdateId;
    }

    public void setPlaydateId(long playdateId) {
        this.playdateId = playdateId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<Long> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Long> attendees) {
        this.attendees = attendees;
    }

    public long getHost() {
        return host;
    }

    public void setHost(long host) {
        this.host = host;
    }
}
