package com.techelevator.controller;


import com.techelevator.dao.PetDao;
import com.techelevator.dao.PlaydateDao;
import com.techelevator.model.Pet;
import com.techelevator.model.Playdate;
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

    @PostMapping (path = "/playdates")
    public void createPlaydate(@RequestBody Playdate playdate, Principal principal) {
        this.playdateDao.createPlaydate(playdate, principal.getName());
    }

}
