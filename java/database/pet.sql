BEGIN TRANSACTION;

DROP TABLE IF EXISTS pet_playdate;
DROP TABLE IF EXISTS pet_message;
DROP TABLE IF EXISTS pets;
DROP SEQUENCE IF EXISTS seq_pet_id;

CREATE SEQUENCE seq_pet_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE pets (
	pet_id int DEFAULT nextval('seq_pet_id'::regclass) NOT NULL,
	pet_name varchar(50) NOT NULL,
	pet_type varchar(25) NOT NULL,
	user_id int NOT NULL CONSTRAINT fk_user_id REFERENCES users(user_id),
	active boolean NOT NULL,
	CONSTRAINT PK_pet_id PRIMARY KEY (pet_id)
);

INSERT INTO pets (pet_name, pet_type, user_id, active) VALUES ('Spot', 'Dog', 6, true);
INSERT INTO pets (pet_name, pet_type, user_id, active) VALUES ('Charlie', 'Dog', 4, true);
INSERT INTO pets (pet_name, pet_type, user_id, active) VALUES ('Sparky', 'Dog', 5, true);
INSERT INTO pets (pet_name, pet_type, user_id, active) VALUES ('Marley', 'Dog', 5, true);
INSERT INTO pets (pet_name, pet_type, user_id, active) VALUES ('Koda', 'Dog', 4, true);
INSERT INTO pets (pet_name, pet_type, user_id, active) VALUES ('Gouda', 'Cat', 7, true);
INSERT INTO pets (pet_name, pet_type, user_id, active) VALUES ('PepperJack', 'Cat', 7, true);

COMMIT TRANSACTION;
