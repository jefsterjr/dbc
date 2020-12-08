create table if not exists estado
(
	id bigserial not null
		constraint estado_pk
			primary key,
	nome varchar not null,
	uf varchar(2) not null,
	bandeira varchar
);

alter table estado owner to admin;

create unique index if not exists estado_id_uindex
	on estado (id);

create table if not exists cidade
(
	id bigserial not null
		constraint cidade_pk
			primary key,
	nome varchar not null,
	populacao bigint,
	estado_id bigint not null
		constraint estado_id_fk
			references estado
);

alter table cidade owner to admin;

create unique index if not exists cidade_id_uindex
	on cidade (id);

