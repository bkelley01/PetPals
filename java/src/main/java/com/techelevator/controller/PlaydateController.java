package com.techelevator.controller;


import com.techelevator.dao.PetDao;
import com.techelevator.dao.PlaydateDao;
import com.techelevator.model.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class PlaydateController {

    PlaydateDao playdateDao;

    public PlaydateController(PlaydateDao playdateDao) {
        this.playdateDao = playdateDao;
    }

}
