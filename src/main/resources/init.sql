create database center_formation;
\c center_formation;

create table training_center(
id_training_center serial primary key,
name varchar(200),
address varchar(200),
contact_details varchar(200),
equipment  text
);

create table class_session(
id serial primary key,
date_session varchar(200),
hour varchar(200),
subject varchar(200),
idTeacher varchar(200)
);

create table course(
id_course serial primary key,
title varchar(200),
description text,
price float,
schedules varchar(200),
id_training_center int,
id_class_session int
);

create table registration(
id_registration serial primary key,
date_registration DATE DEFAULT CURRENT_DATE,
status varchar(200),
id_user varchar(200),
id_course int
);

create table wave(
id_wave serial primary key,
id_course int,
start_date varchar(200),
end_date varchar(200)
);


