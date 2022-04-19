package com.techelevator.controller;

import com.techelevator.dao.MessageDao;
import com.techelevator.model.Message;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
