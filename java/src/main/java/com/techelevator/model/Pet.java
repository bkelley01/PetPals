package com.techelevator.model;

import java.util.List;

public class Pet {

    // Instance variables
    private long petId;
    private String petName;
    private String petType;
    private List<String> personalities;
    private long userId;
    private String username;
    private boolean active;

    // getters & setters
    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String animalType) {
        this.petType = animalType;
    }

    public List<String> getPersonalities() {
        return personalities;
    }

    public void setPersonalities(List<String> personalities) {
        this.personalities = personalities;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
