package com.techelevator.dao;

import java.util.List;
import com.techelevator.model.Message;

public interface MessageDao {
    List<Message> getAllMessages();

    boolean createMessage(Message newMessage);

    boolean deleteMessage();

    boolean updateMessage(Message updatedMessage);
}
