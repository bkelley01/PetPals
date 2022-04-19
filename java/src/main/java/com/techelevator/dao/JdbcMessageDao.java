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
                "WHERE msg_deleted = false;";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        while (rs.next()) {
            messages.add(mapRowToMessage(rs));
        }
        return messages;
    }

    @Override
    public boolean createMessage(Message newMessage) {
        return false;
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

        message.setPetIds(getPetIdsByMessageId(message.getMessageId()));

        return message;
    }

    private List<Long> getPetIdsByMessageId(long messageId) {
        List<Long> petIds = new ArrayList<>();
        String sql = "SELECT pet_id\n" +
                "FROM pet_message\n" +
                "WHERE message_id = ?;";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, messageId);
        while (rs.next()) {
            petIds.add(rs.getLong("pet_id"));
        }
        return petIds;
    }
}
