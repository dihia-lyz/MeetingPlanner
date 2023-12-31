create table if not exists salle_equipment (
	salle_id bigint,
	equipment_id bigint ,
	foreign key (salle_id ) references salle(id),
	foreign key (equipment_id ) references fixed_equipment(id)
);

insert INTO salle_equipment (salle_id, equipment_id) VALUES
    (2,1),
    (3,2),
    (4,3),
    (6,1),
    (6,4),
    (8,3),
    (9,1),
    (9,2),
    (9,4),
    (11,1),
    (11,2);

