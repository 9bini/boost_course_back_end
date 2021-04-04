create table guestbook(
	id bigint(20) unsigned not null auto_increment,
    name varchar(255) not null,
    context text,
    redgdate datetime,
    primary key (id)
);

create table log(
	id bigint(20) unsigned not null auto_increment,
    ip varchar(255) not null,
    method varchar(10) not null,
    redgdate datetime,
    primary key (id)
);