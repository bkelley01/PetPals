BEGIN TRANSACTION;

DROP TABLE IF EXISTS pet_playdate;

CREATE TABLE pet_playdate (
	pet_id int NOT NULL CONSTRAINT fk_pet_id REFERENCES pets(pet_id),
	playdate_id int NOT NULL CONSTRAINT fk_playdate_id REFERENCES playdates(playdate_id),
	acceptance_status varchar(20) NOT NULL,
	PRIMARY KEY (playdate_id, pet_id),
	CONSTRAINT chk_stat CHECK (acceptance_status in ('Accepted','Declined', 'Pending'))
);

INSERT INTO pet_playdate (pet_id, playdate_id, acceptance_status) VALUES (1, 1, 'Accepted');
INSERT INTO pet_playdate (pet_id, playdate_id, acceptance_status) VALUES (1, 2, 'Accepted');
INSERT INTO pet_playdate (pet_id, playdate_id, acceptance_status) VALUES (2, 4, 'Accepted');
INSERT INTO pet_playdate (pet_id, playdate_id, acceptance_status) VALUES (3, 3, 'Accepted');
INSERT INTO pet_playdate (pet_id, playdate_id, acceptance_status) VALUES (4, 3, 'Accepted');
INSERT INTO pet_playdate (pet_id, playdate_id, acceptance_status) VALUES (7, 1, 'Accepted');
INSERT INTO pet_playdate (pet_id, playdate_id, acceptance_status) VALUES (6, 1, 'Accepted');


COMMIT TRANSACTION;