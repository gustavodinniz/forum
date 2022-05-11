create table TB_COURSES
(
    id       bigint      not null auto_increment,
    name     varchar(50) not null,
    category varchar(50) not null,
    primary key (id)
);

insert into TB_COURSES(id, name, category)
values (1, 'Kotlin', 'Backend');
insert into TB_COURSES(id, name, category)
values (2, 'Java 11', 'Backend');
insert into TB_COURSES(id, name, category)
values (3, 'Angular', 'Frontend');
insert into TB_COURSES(id, name, category)
values (4, 'React', 'Frontend');
insert into TB_COURSES(id, name, category)
values (5, 'Docker', 'Cloud');

