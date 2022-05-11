create table TB_COURSES
(
    id       bigint      not null auto_increment,
    name     varchar(50) not null,
    category varchar(50) not null,
    primary key (id)
);

insert into TB_COURSES(id, name, category)
values (1, 'Kotlin', 'Backend');
values (2, 'Java 11', 'Backend');
values (3, 'Angular', 'Frontend');
values (4, 'React', 'Frontend');
values (5, 'Docker', 'Cloud');

