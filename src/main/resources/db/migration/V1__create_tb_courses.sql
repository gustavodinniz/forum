create table TB_COURSES
(
    id       bigint      not null,
    name     varchar(50) not null,
    category varchar(50) not null,
    primary key (id)
);

insert into TB_COURSES(id, name, category)
values (1, 'Kotlin', 'API REST com Kotlin e Spring Boot');

