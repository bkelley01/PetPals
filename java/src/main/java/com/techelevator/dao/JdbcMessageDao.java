package com.techelevator.dao;

import com.techelevator.model.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMessageDao implements MessageDao {
    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;

    //Constructor
    public JdbcMessageDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }

    @Override
    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT message_id, user_id, posted_at, msg_text\n" +
                     "FROM messages\n" +
                     "WHERE msg_deleted = false " +
                     "ORDER BY posted_at DESC;";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        while (rs.next()) {
            messages.add(mapRowToMessage(rs));
        }
        return messages;
    }

    @Override
    public boolean createMessage(Message newMessage) {
        String sql = "INSERT INTO messages (user_id, msg_text, msg_deleted)\n" +
                "VALUES (1, 'Test message posted', false)\n" +
                "RETURNING message_id;";
        Long userId = userDao.findIdByUsername(newMessage.getSenderUsername());
        Long messageId = jdbcTemplate.queryForObject(sql, Long.class, userId, newMessage.getMessageText());

        for (String petName : newMessage.getPetNames()) {
            addPetMessageRecord(messageId, userId, petName);
        }

        if (messageId != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteMessage(long messageId) {
        return false;
    }

    @Override
    public boolean updateMessage(Message updatedMessage, long messageId) {
        return false;
    }

    private Message mapRowToMessage(SqlRowSet rs) {
        Message message = new Message();
        message.setMessageId(rs.getLong("message_id"));
        message.setSenderUsername(userDao.getUserById(rs.getLong("user_id")).getUsername());
        message.setMessageText(rs.getString("msg_text"));
        message.setMessageTimestamp(rs.getTimestamp("posted_at").toLocalDateTime());

        message.setPetNames(getPetNamesByMessageId(message.getMessageId()));

        return message;
    }

    private List<String> getPetNamesByMessageId(long messageId) {
        List<String> petIds = new ArrayList<>();
        String sql = "SELECT pet_name " +
                     "FROM pets " +
                        "JOIN pet_message ON pet_message.pet_id = pets.pet_id " +
                     "WHERE message_id = ?;";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, messageId);
        while (rs.next()) {
            petIds.add(rs.getString("pet_name"));
        }
        return petIds;
    }

    private void addPetMessageRecord(Long messageId, Long userId, String petName) {
        String sql = "INSERT INTO pet_message (message_id, pet_id)\n" +
                "VALUES (?,(\n" +
                "\tSELECT pet_id\n" +
                "\tFROM pets\n" +
                "\tWHERE pet_name = ? AND user_id = ? AND active = true\n" +
                "\tORDER BY pet_id DESC LIMIT 1\n" +
                "));";
        jdbcTemplate.update(sql, messageId, petName, userId);
    }
}
