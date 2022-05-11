create table TB_USERS
(
    id    bigint      not null auto_increment,
    name  varchar(50) not null,
    email varchar(50) not null,
    primary key (id)
);

insert into TB_USERS(id, name, email)
values (1, 'Gustavo Diniz', 'gustavodinniz@hotmail.com');
insert into TB_USERS(id, name, email)
values (2, 'Alberto Chaves', 'alberto@hotmail.com');
insert into TB_USERS(id, name, email)
values (3, 'Marisa', 'marisa@hotmail.com');
insert into TB_USERS(id, name, email)
values (4, 'Erica', 'erica@hotmail.com');
insert into TB_USERS(id, name, email)
values (5, 'Camila', 'camila@hotmail.com');
