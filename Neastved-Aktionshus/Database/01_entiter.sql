drop database if exists na;
create database na;
use na;

drop table if exists product;
create table product(
p_name varchar (255) not null,
p_description text not null,
p_estimatedPrice int not null,
primary key (p_name, p_description, p_estimatedPrice)
) engine = InnoDB;



