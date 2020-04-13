
DROP TABLE IF EXISTS room CASCADE;
DROP TABLE IF EXISTS equipment CASCADE;

CREATE TABLE IF NOT EXISTS room (
	room_id SERIAL NOT NULL,
	room_name VARCHAR(255) NOT NULL,
	capacity INT4 NOT NULL,
	build_date DATE NOT NULL,
	PRIMARY KEY (room_id)
);


CREATE TABLE IF NOT EXISTS equipment (
	equipment_id SERIAL NOT NULL,
	room_id INT4,
	equipment_name VARCHAR(30) NOT NULL,
	equipment_count INT4 NOT NULL,
	equipment_remarks VARCHAR(100),
	PRIMARY KEY (equipment_id)
);


ALTER TABLE equipment DROP CONSTRAINT IF EXISTS FK_ROOM_ID;
ALTER TABLE equipment ADD CONSTRAINT FK_ROOM_ID FOREIGN KEY (room_id) REFERENCES room;
