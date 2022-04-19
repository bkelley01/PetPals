package com.techelevator.controller;

import com.techelevator.dao.MessageDao;
import com.techelevator.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class MessageController {

    MessageDao messageDao;

    public MessageController(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @GetMapping (path = "/messages")
    public List<Message> getAllMessages() {
        return this.messageDao.getAllMessages();
    }

    @ResponseStatus (HttpStatus.CREATED)
    @PostMapping (path = "/messages")
    public void createMessage(@RequestBody Message message, Principal principal) {
        if (principal.getName().equals(message.getSenderUsername())) {
            messageDao.createMessage(message);
        };
    }
}
