create table TB_USERS
(
    id    bigint      not null,
    name  varchar(50) not null,
    email varchar(50) not null,
    primary key (id)
);

insert into TB_USERS(id, name, email)
values (1, 'Gustavo Diniz', 'gustavodinniz@hotmail.com');