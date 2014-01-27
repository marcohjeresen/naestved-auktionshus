drop database if exists na;
create database na;
use na;

drop table if exists product;
create table product(
p_name varchar (255) not null,
p_description varchar(255) not null,
p_estimatedPrice int not null,
p_picturePath varchar(255) not null,
primary key (p_name, p_description, p_estimatedPrice, p_picturePath)
) engine = InnoDB;

drop table if exists wine;
create table wine(
manufacturer varchar (255) not null,
country varchar(255) not null,
productionYear int not null,
grapes varchar(255) not null,
percent double not null,
botttleSize double not null,
quantity int not null
) engine = InnoDB;

drop table if exists furniture;
create table furniture(
materials varchar (255) not null,
dimensions varchar(40) not null
) engine = InnoDB;

drop table if exists painting;
create table painting(
artist varchar (255) not null,
productionYear int not null,
style varchar(255) not null,
size varchar(255) not null
) engine = InnoDB;

drop table if exists jewellery;
create table jewellery(
metal varchar (255) not null,
gemstone varchar(255) not null,
stamp varchar(255) not null
) engine = InnoDB;

