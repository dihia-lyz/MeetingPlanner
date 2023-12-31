CREATE TABLE if NOT EXISTS fixed_equipment(
 id bigint PRIMARY KEY,
 name varchar,
 equipment_number int
);

INSERT INTO fixed_equipment (id,name,equipment_number) VALUES
	 (1,'écran',4),
	 (2,'pieuvre',3),
	 (3,'tableau',2),
	 (4,'webcam',2)