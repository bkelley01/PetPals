BEGIN TRANSACTION;

DROP TABLE IF EXISTS pet_personality;

CREATE TABLE pet_personality (
	pet_id int NOT NULL CONSTRAINT fk_pet_id REFERENCES pets(pet_id),
	personality varchar(20) NOT NULL,
	PRIMARY KEY(pet_id, personality)
);

INSERT INTO pet_personality (pet_id, personality) VALUES (1, 'Friendly');
INSERT INTO pet_personality (pet_id, personality) VALUES (1, 'Curious');
INSERT INTO pet_personality (pet_id, personality) VALUES (1, 'Playful');

COMMIT TRANSACTION;