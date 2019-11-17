DROP TABLE IF EXISTS user;
create table user
(
   id integer not null,
   email_id varchar(255) not null,
   first_name varchar(255) not null,
   last_name varchar(255) not null,
   primary key(id)
);
