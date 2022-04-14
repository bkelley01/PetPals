BEGIN TRANSACTION;

DROP TABLE IF EXISTS pets;
DROP SEQUENCE IF EXISTS seq_pet_id;

CREATE SEQUENCE seq_pet_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE pets (
	pet_id int DEFAULT nextval('seq_pet_id'::regclass) NOT NULL,
	pet_name varchar(50) UNIQUE NOT NULL,
	pet_type varchar(25) NOT NULL,
	user_id int NOT NULL CONSTRAINT fk_user_id REFERENCES users(user_id),
	CONSTRAINT PK_pet_id PRIMARY KEY (pet_id)
);

INSERT INTO pets (pet_name, pet_type, user_id) VALUES ('Spot', 'Dog', 1);
INSERT INTO pets (pet_name, pet_type, user_id) VALUES ('Charlie', 'Dog', 1);
INSERT INTO pets (pet_name, pet_type, user_id) VALUES ('Sparky', 'Dog', 3);
INSERT INTO pets (pet_name, pet_type, user_id) VALUES ('Marley', 'Dog', 3);

COMMIT TRANSACTION;
