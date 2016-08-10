create database if not exists gfi_academy;
use gfi_academy;
drop table if exists messages;
create table messages(
	id bigint auto_increment not null primary key,
	message varchar(255) not null
);
insert into messages(message) values ('Foo bar from the database!');
insert into messages(message) values ('Bar foo from the database!');