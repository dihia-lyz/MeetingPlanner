create table if not exists removable_equipment(
    id bigint primary key,
    name varchar,
    equipment_number int
);

INSERT INTO removable_equipment (id,name,equipment_number) VALUES
	 (1,'écran',5),
	 (2,'pieuvre',4),
	 (3,'tableau',2),
	 (4,'webcam',4)