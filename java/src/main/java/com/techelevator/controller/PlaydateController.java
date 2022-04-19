package com.techelevator.controller;


import com.techelevator.dao.PetDao;
import com.techelevator.dao.PlaydateDao;
import com.techelevator.model.Pet;
import com.techelevator.model.Playdate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class PlaydateController {

    PlaydateDao playdateDao;

    public PlaydateController(PlaydateDao playdateDao) {
        this.playdateDao = playdateDao;
    }

    @GetMapping (path="/playdates/{username}")
    public List<Playdate> getPlaydatesByUsername(@PathVariable String username) {
        return this.playdateDao.getPlaydatesByUsername(username);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping (path = "/playdates")
    public void createPlaydate(@RequestBody Playdate playdate, Principal principal) {
        this.playdateDao.createPlaydate(playdate, principal.getName());
    }

    @GetMapping (path = "/playdates")
    public List<Playdate> getAllPlaydates() {
        return this.playdateDao.getAllPlaydates();
    }

    @GetMapping (path = "/pet-playdate/{petId}")
    public List<Playdate> getPlaydatesByPetId(@PathVariable long petId) {
        return this.playdateDao.getPlaydatesByPetId(petId);
    }

}
