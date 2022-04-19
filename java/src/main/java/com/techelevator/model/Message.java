package com.techelevator.model;

import java.time.LocalDateTime;

public class Message {

    // Instance variables
    private Long messageId;
    private Long senderId;
    private Long petId;
    private String messageText;
    private LocalDateTime messageTimestamp;

    // getters & setters
    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public LocalDateTime getMessageTimestamp() {
        return messageTimestamp;
    }

    public void setMessageTimestamp(LocalDateTime messageTimestamp) {
        this.messageTimestamp = messageTimestamp;
    }
}
