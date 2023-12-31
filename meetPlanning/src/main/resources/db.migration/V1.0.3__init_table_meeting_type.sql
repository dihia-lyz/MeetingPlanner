create table meeting_type(
	id bigint primary key,
	name varchar ,
	min_collaborators_number int
);

INSERT INTO meeting_type (id,name,min_collaborators_number) VALUES
	 (1,'Visioconférence (VC) ',NULL),
	 (2,'Séances de partage et d''études de cas (SPEC)',NULL),
	 (3,'Réunion simple (RS)',3),
	 (4,'Réunion couplée (RC)',NULL);