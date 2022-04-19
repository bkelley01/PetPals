BEGIN TRANSACTION;

DROP TABLE IF EXISTS pet_message;

CREATE TABLE pet_message (
	pet_id int NOT NULL CONSTRAINT fk_pet_id REFERENCES pets(pet_id),
	message_id int NOT NULL CONSTRAINT fk_message_id REFERENCES messages(message_id),
	PRIMARY KEY(pet_id, message_id)
);

INSERT INTO pet_message (pet_id, message_id) VALUES (1, 1);
INSERT INTO pet_message (pet_id, message_id) VALUES (3, 1);
INSERT INTO pet_message (pet_id, message_id) VALUES (2, 2);

COMMIT TRANSACTION;