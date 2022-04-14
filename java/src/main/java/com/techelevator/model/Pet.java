package com.techelevator.model;

import java.util.List;

public class Pet {

    // Instance variables
    private long petId;
    private String petName;
    private String animalType;
    private List<String> personalities;
    private long userId;

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

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
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
}
