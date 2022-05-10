create table TB_ANSWERS
(
    id            bigint       not null auto_increment,
    message       varchar(300) not null,
    creation_date datetime     not null,
    topic_id      bigint       not null,
    author_id     bigint       not null,
    solution      int(1) not null,
    primary key (id),
    foreign key (author_id) references TB_USERS (id),
    foreign key (topic_id) references TB_TOPICS (id)
);
