create table if not exists equipment_reservation(
    id bigint primary key,
    equipment_id bigint,
    reservation_id bigint,
    foreign key (equipment_id) references removable_equipment(id),
    foreign key(reservation_id) references reservation(id)
)