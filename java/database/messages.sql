BEGIN TRANSACTION;

DROP TABLE IF EXISTS pet_message;
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
	posted_at timestamp DEFAULT CURRENT_TIMESTAMP,
	msg_text varchar(280) NOT NULL,
	msg_deleted boolean DEFAULT false,
	CONSTRAINT PK_message PRIMARY KEY (message_id)
);

INSERT INTO messages (user_id, msg_text)
VALUES (6, 'The weather is so nice today, I''m taking Spot to Fido Park around 3:30, hope to see some of you there!');

INSERT INTO messages (user_id, msg_text)
VALUES (4, 'Charlie can''t stay still for more than 20 minutes, off to Winton Woods we go!');

COMMIT TRANSACTION;