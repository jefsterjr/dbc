create database database_name with owner postgres;

create schema ticket_log;

alter schema ticket_log owner to postgres;

create table ticket_log.estado
(
    id       bigserial  not null
        constraint estado_pk
            primary key,
    nome     varchar    not null,
    uf       varchar(2) not null,
    bandeira varchar
);

alter table ticket_log.estado
    owner to postgres;

create unique index estado_id_uindex
    on ticket_log.estado (id);

create table ticket_log.cidade
(
    id        bigserial not null
        constraint cidade_pk
            primary key,
    nome      varchar   not null,
    populacao bigint,
    estado_id bigint    not null
        constraint estado_id_fk
            references ticket_log.estado
);

alter table ticket_log.cidade
    owner to postgres;

create unique index cidade_id_uindex
    on ticket_log.cidade (id);

