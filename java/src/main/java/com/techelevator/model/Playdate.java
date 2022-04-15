package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

public class Playdate {

    private long playdateId;
    private String playdateTitle;
    private String playdateLocation;
    private LocalDate playdateDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<String> attendees;
    private String host;
    private boolean isActive;

    public long getPlaydateId() {
        return playdateId;
    }

    public void setPlaydateId(long playdateId) {
        this.playdateId = playdateId;
    }

    public String getPlaydateTitle() {
        return playdateTitle;
    }

    public void setPlaydateTitle(String playdateTitle) {
        this.playdateTitle = playdateTitle;
    }

    public String getPlaydateLocation() {
        return playdateLocation;
    }

    public void setPlaydateLocation(String playdateLocation) {
        this.playdateLocation = playdateLocation;
    }

    public LocalDate getPlaydateDate() {
        return playdateDate;
    }

    public void setPlaydateDate(LocalDate playDate) {
        this.playdateDate = playDate;
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

    public List<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<String> attendees) {
        this.attendees = attendees;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
