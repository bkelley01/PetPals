BEGIN TRANSACTION;

DROP TABLE IF EXISTS messages;
DROP SEQUENCE IF EXISTS seq_message_id;

CREATE SEQUENCE seq_message_id
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;
  
CREATE TABLE messages(
	message_id int DEFAULT nextval('seq_message_id'::regclass) NOT NULL,
	user_id int NOT NULL CONSTRAINT fk_user_id REFERENCES users(user_id),
	pet_id int NULL CONSTRAINT fk_pet_id REFERENCES pets(pet_id),
	posted_at timestamp DEFAULT CURRENT_TIMESTAMP,
	msg_text varchar(280) NOT NULL,
	msg_deleted boolean DEFAULT false
);

INSERT INTO messages (user_id, pet_id, msg_text)
VALUES (3, 1, 'The default user left a test message about Spot');

INSERT INTO messages (user_id, msg_text)
VALUES (3, 'The default user left a generic test message');

COMMIT TRANSACTION;