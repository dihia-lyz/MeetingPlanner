create table if not exists reservation(
    id bigint primary key ,
     salle_id bigint,
     meeting_id bigint,
     foreign key (salle_id) references salle(id),
     foreign key (meeting_id) references meeting(id)
)