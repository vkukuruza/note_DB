create table users
(
	id int auto_increment,
	email varchar(80) not null,
	password varchar(100) not null,
	name varchar(60) not null,
	created_at date not null,
	deleted_at date null default null,
	constraint users_pk
		primary key (id)
);

create unique index users_email_uindex
	on users (email);

	INSERT INTO note.users (id, email, password, name, created_at, deleted_at)
    VALUES (1, 'igor@lyutak.com', '1122', 'Igor', '2020-05-07', null);