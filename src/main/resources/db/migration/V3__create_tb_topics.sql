create table TB_TOPICS
(
    id            bigint       not null auto_increment,
    title         varchar(50)  not null,
    message       varchar(300) not null,
    creation_date datetime     not null,
    status        varchar(20)  not null,
    course_id     bigint       not null,
    author_id     bigint       not null,
    primary key (id),
    foreign key (course_id) references TB_COURSES (id),
    foreign key (author_id) references TB_USERS (id)
);

